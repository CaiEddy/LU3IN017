package services;

import java.util.ArrayList;
import org.json.JSONObject;
import BD.Connexion_BD;
import tools.*;

public class User_services {
	// 1-	Verifie si argument vide/null (si besoin)
	// 2- 	Ouverture de la connection a la BD
	// 3-	Verifie si le token existe dans la BD (si besoin)
	// 4-	Test parametres (si besoin)
	// 5-	Recupere les informations + creation/return du JSON
	// 6-	Fermeture de la connection a la BD
	
	
	public static JSONObject getUser(String id) throws Exception {
		try {
			// Verifie si un argument est vide ou null
			if(Mini_tools.null_vide(id)){
				// Message erreur si arguement vide ou null
				return ErrorJSON.serviceRefused("argument vide/null pour la methode getUser", -1);
			}
			
			
			// ouverture de la connection
			Connexion_BD.open_connexion_BD();
			
			
			// Verifie si le token existe
			if(!Authentification_tools.test_token(id)){
				// Message erreur si le token de ID est inconnu par la base de donnee
				return ErrorJSON.serviceRefused("Le TOKEN de l'ID("+id+") n'existe pas pour la methode getUser", -1);
			}
			
			
			// Verifie si ID existe
			if(!User_tools.exist_id(id)) {
				// Message erreur si ID est inconnu par la base de donnee
				return ErrorJSON.serviceRefused("L'utilisateur ID("+id+") n'existe pas pour la methode getUser", -1);
			}
			
			
			// Acces aux informations de l'utilisateur
			ArrayList<String> information = Mini_tools.requeteGET("Select * From "+User_tools.table+" Where id='"+id+"' ;");
			// Acces aux nom des attributs des informations
			ArrayList<String> nom_attributs = Mini_tools.acces_nom_attributs("Select * From "+User_tools.table+" Where id='"+id+"' ;");
			
			
			// Creation du json
			return Mini_tools.creation_json(information, nom_attributs);
		}finally {
			// fermerture de la connection
			Connexion_BD.close_connexion_BD();
		}
		
	}
	
	
	public static JSONObject getUserlist() throws Exception {
		try {
			// ouverture de la connection
			Connexion_BD.open_connexion_BD();
			
			
			// Acces aux informations des utilisateurs
			ArrayList<String> information = Mini_tools.requeteGET("Select id,pseudo From "+User_tools.table+" ;");
			// Acces aux nom des attributs des informations
			ArrayList<String> nom_attributs = Mini_tools.acces_nom_attributs("Select id,pseudo From "+User_tools.table+" ;");
			
			
			// Creation du json
			return Mini_tools.creation_json(information, nom_attributs);
		}finally {
			// fermerture de la connection
			Connexion_BD.close_connexion_BD();
			}
	}
	
	
	public static JSONObject createUser (String login, String password, String prenom, 
										 String nom, String pseudo, String mail, String sexe,
										 String date_de_naissance) throws Exception {
		try {
			// Verifie si un argument est vide ou null
			if(Mini_tools.null_vide(login) || Mini_tools.null_vide(password) || 
			   Mini_tools.null_vide(prenom) || Mini_tools.null_vide(nom) || 
			   Mini_tools.null_vide(pseudo) || Mini_tools.null_vide(mail) || 
			   Mini_tools.null_vide(sexe) || Mini_tools.null_vide(date_de_naissance)) {
				// Message erreur si arguement vide ou null
				return ErrorJSON.serviceRefused("argument vide/null pour la methode UserCreate", -1);
			}
			
			
			// ouverture de la connection
			Connexion_BD.open_connexion_BD();
			
			
			// Verifie si le login existe deja
			if(User_tools.exist_login(login)) {
				// Message erreur si le login existe deja
				return ErrorJSON.serviceRefused("Le login "+login+" existe deja pour la methode createUser", -1);
			}
			
			
			// Verifie si la creation de l'user est correct
			if(!User_tools.creation_user(login, password, prenom, nom, pseudo, mail, sexe, date_de_naissance)) {
				// Message erreur si probleme lors de la creation 
				return ErrorJSON.serviceRefused("Erreur lors de la creation de l'user pour la methode deleteUser", -1);
			}

			
			// Acces aux informations de l'utilisateur 
			ArrayList<String> information = Mini_tools.requeteGET("Select * From "+User_tools.table+" Where login='"+login+"' ;");
			// Acces aux nom des attributs des informations
			ArrayList<String> nom_attributs = Mini_tools.acces_nom_attributs("Select * From "+User_tools.table+" Where login='"+login+"' ;");
			
			
			// Creation du json
			return Mini_tools.creation_json(information, nom_attributs);
		}finally {
			// fermerture de la connection
			Connexion_BD.close_connexion_BD();
		}
	}
	
	
	public static JSONObject deleteUser(String id) throws Exception {
		try {
			// Verifie si un argument est vide ou null
			if(Mini_tools.null_vide(id)){
				// Message erreur si arguement vide ou null
				return ErrorJSON.serviceRefused("argument vide/null pour la methode deleteUser", -1);
			}
			
			
			// ouverture de la connection
			Connexion_BD.open_connexion_BD();
			
			
			// Verifie si le token existe
			if(!Authentification_tools.test_token(id)){
				// Message erreur si le token de ID est inconnu par la base de donnee
				return ErrorJSON.serviceRefused("Le TOKEN de l'ID("+id+") n'existe pas pour la methode deleteUser", -1);
			}
			
			
			// Verifie si ID existe
			if(!User_tools.exist_id(id)) {
				// Message erreur si ID est inconnu par la base de donnee
				return ErrorJSON.serviceRefused("L'utilisateur ID("+id+") est inconnu pour la methode deleteUser", -1);
			}
			
			
			// Verifie si la suppression ID se fait correctement
			if(!User_tools.delete_id_user(id)){
				// Message erreur si probleme lors de la suppression
				return ErrorJSON.serviceRefused("Erreur lors de la suppression de l'ID("+id+") pour la methode deleteUser", -1);
			}
			
			
			// Creation du json
			return ErrorJSON.serviceAccepted("ok");
		}finally {
			// fermerture de la connection
			Connexion_BD.close_connexion_BD();
		}
	}
}
