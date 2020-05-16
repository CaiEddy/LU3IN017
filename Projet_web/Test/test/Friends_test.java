package test;

import services.Friends_services;
import services.Authentification_services;

public class Friends_test {
	public static void main(String[] args) throws Exception {
		int id = 1;
		System.out.println("JEUX DE TEST POUR TOUTE LES METHODES Friends_services\n");
		

		// login de id
		//Authentification_services.login("Chako","luludu38");

		// getFriendList
		System.out.println("METHODE          : Friends_services.getFriendList(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Tous les amis de l'utilisateur d'ID : "+id);
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Friends_services.getFriendList(String.valueOf(id)));
		System.out.println("\n\n");
		
		
		int id1 = 1;
		int id2 = 3;
		
		
		// addFriend
		System.out.println("METHODE          : Friends_services.addFriend(String.valueOf("+id1+"),String.valueOf("+id2+"))");
		System.out.println("RESULTAT_ATTENDU : Ajout de l'amitie de ID("+id1+") vers ID("+id2+")");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Friends_services.addFriend(String.valueOf(id1), String.valueOf(id2)));
		System.out.println("\n\n");
		
		
		// getFriendList
		System.out.println("verification que l'amitie ID("+id1+") vers ID("+id2+") est dans la base de donnee");
		System.out.println("METHODE          : Friends_services.getFriendList(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Tous les amis de l'utilisateur d'ID : "+id);
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Friends_services.getFriendList(String.valueOf(id)));
		System.out.println("\n\n");
		
		
		// deleteFriend
		System.out.println("METHODE          : Friends_services.deleteFriend(String.valueOf("+id1+"),String.valueOf("+id2+"))");
		System.out.println("RESULTAT_ATTENDU : Suppression de l'amitie de ID("+id1+") vers ID("+id2+")");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Friends_services.deleteFriend(String.valueOf(id1), String.valueOf(id2)));
		System.out.println("\n\n");
		

		// getFriendList
		System.out.println("verification que l'amitie ID("+id1+") vers ID("+id2+") a ete supprimer de la base de donnee");
		System.out.println("METHODE          : Friends_services.getFriendList(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Tous les amis de l'utilisateur d'ID : "+id);
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Friends_services.getFriendList(String.valueOf(id)));
		System.out.println("\n\n");
	}

}
