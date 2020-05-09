package test;
import services.User_services;


public class User_test {

	public static void main(String[] args) throws Exception {

		int id = 1;
		System.out.println("JEUX DE TEST POUR TOUTE LES METHODES User_services\n");
		// getUserlist
		System.out.println("METHODE          : User_services.getUserlist()");
		System.out.println("RESULTAT_ATTENDU : ID et pseudo de tous les utilisateurs");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.getUserlist());
		System.out.println("\n\n");

		
		// getUser
		System.out.println("METHODE          : User_services.getUser(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Les informations de ID("+id+")");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.getUser(String.valueOf(id)));
		System.out.println("\n\n");
	
	
		String login = "toto_login";
		String password = "toto_password";
		String prenom = "toto_prenom";
		String nom = "toto_nom";
		String pseudo = "toto_pseudo";
		String mail = "toto_mail";
		String sexe = "toto_sexe";
		String date_naissance = "2020-02-20";
		
		
		// createUser
		System.out.println("METHODE          : User_services.createUser("+login+","+password+","+prenom+","+nom+","+pseudo+","+mail+","+sexe+","+date_naissance+")");
		System.out.println("RESULTAT_ATTENDU : creation de l'utilisateur "+login);
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.createUser(login,password,prenom,nom,pseudo,mail,sexe,date_naissance));
		System.out.println("\n\n");
		

		// getUserlist
		System.out.println("verification que "+login+" est bien dans la base de donnees");
		System.out.println("METHODE          : User_services.getUserlist()");
		System.out.println("RESULTAT_ATTENDU : ID et pseudo de tous les utilisateurs");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.getUserlist());
		System.out.println("\n\n");
		
		
		login = "toto_login";
		password = "hello_password";
		prenom = "hello_prenom";
		nom = "hello_nom";
		pseudo = "hello_pseudo";
		mail = "hello_mail";
		sexe = "hello_sexe";
		date_naissance = "1999-09-19";
		
		
		// createUser
		System.out.println("verification qu'on ne peut pas avoir un utilisateur avec le meme login ("+login+")");
		System.out.println("METHODE          : User_services.createUser("+login+","+password+","+prenom+","+nom+","+pseudo+","+mail+","+sexe+","+date_naissance+")");
		System.out.println("RESULTAT_ATTENDU : Le login "+login+" existe deja");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.createUser(login,password,prenom,nom,pseudo,mail,sexe,date_naissance));
		System.out.println("\n\n");
		
		
		id = 5;
		
		
		// deleteUser
		System.out.println("METHODE          : User_services.deleteUser(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Suppression de ID("+id+") dans la base de donnees");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.deleteUser(String.valueOf(id)));
		System.out.println("\n\n");
		
		
		// getUserlist
		System.out.println("verification que ID : "+id+" a ete supprimer de la base de donnees");
		System.out.println("METHODE          : User_services.getUserlist()");
		System.out.println("RESULTAT_ATTENDU : ID et pseudo de tous les utilisateurs");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(User_services.getUserlist());
		System.out.println("\n\n");	
		

		}
	}

