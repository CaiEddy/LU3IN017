package test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import BD.Connexion_BD;
import services.Authentification_services;
import tools.Authentification_tools;
import tools.Mini_tools;
import tools.User_tools;

public class Authentification_test {
	public static void main(String[] args) throws Exception {
		System.out.println("JEUX DE TEST POUR TOUTE LES METHODES Authentification_services\n");
		String login = "Chako";
		Connexion_BD.open_connexion_BD();
		ArrayList<String> id_list = Mini_tools.requeteGET("Select id From "+User_tools.table+" Where login='"+login+"' ;");
		String id = id_list.get(0);
		
		ArrayList<String> mdp_list = Mini_tools.requeteGET("Select password From "+User_tools.table+" Where id='"+id+"' ;");
		String mdp = mdp_list.get(0);

		
		// login
		System.out.println("METHODE          : Authentification_services.login("+login+","+mdp+")");
		System.out.println("RESULTAT_ATTENDU : ID,token,date_debut,date_fin");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Authentification_services.login(login,mdp));
		System.out.println("\n\n");
		
		
		System.out.println("JE FAIS UN SLEEP DE 5 secondes");
		TimeUnit.SECONDS.sleep(5);
		
		
		// test_token
		System.out.println("METHODE          : Authentification_tools.test_token(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Mise a jour de date_debut et date_fin et renvoi true");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Authentification_tools.test_token(String.valueOf(id)));
		System.out.println("\n\n");
		
		
		// Acces aux informations du token
		ArrayList<String> information = Mini_tools.requeteGET("Select * From "+Authentification_tools.table+" Where id='"+id+"' ;");
		// Acces aux nom des attributs des informations
		ArrayList<String> nom_attributs = Mini_tools.acces_nom_attributs("Select * From "+Authentification_tools.table+" Where id='"+id+"' ;");
		
		
		// test pour savoir si la date_debut et date_fin ont ete mise a jour
		System.out.println("test pour savoir si la date_debut et date_fin ont ete mise a jour");
		System.out.println("METHODE          : Mini_tools.creation_json(information, nom_attributs)");
		System.out.println("RESULTAT_ATTENDU : Les informations concernant le token");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Mini_tools.creation_json(information, nom_attributs));
		System.out.println("\n\n");
		
		
		// logout
		System.out.println("METHODE          : Authentification_tools.logout(String.valueOf("+id+"))");
		System.out.println("RESULTAT_ATTENDU : Suppression du token de ID("+id+") de la base de donnee et renvoie {} (ok)");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Authentification_services.logout(String.valueOf(id)));
		System.out.println("\n\n");
		
		
		
	}
}
