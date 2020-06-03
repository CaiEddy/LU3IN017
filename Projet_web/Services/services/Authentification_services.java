package services;

import java.util.ArrayList;
import org.json.JSONObject;
import tools.Authentification_tools;
import tools.ErrorJSON;
import tools.Mini_tools;
import tools.User_tools;

public class Authentification_services {
	// 1- Verifie si argument vide/null (si besoin)
	// 2- Verifie si le token existe dans la BD (si besoin)
	// 3- Test parametres (si besoin)
	// 4- Recupere les informations + creation/return du JSON

	public static JSONObject login(String login, String password) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(login) || Mini_tools.null_vide(password)) {
			return ErrorJSON.serviceRefused("argument vide/null pour la methode login", -1);
		}

		// Verifie si le login existe
		if (!User_tools.exist_login(login)) {
			// Message erreur si login existe pas
			return ErrorJSON.serviceRefused("Le login n'existe pas ", -1);
		}

		// Verifie si password est correct
		if (!Mini_tools.in_bd(password, "password", User_tools.table)) {
			// Message erreur si le password est incorrect
			return ErrorJSON.serviceRefused("Le password est invalide pour la methode login", -1);
		}

		// Acces au ID de login
		ArrayList<String> getID = Mini_tools
				.requeteGET("Select id From " + User_tools.table + " Where login='" + login + "' ;");
		String id = getID.get(0);

		// Verifie si le token existe
		if (Authentification_tools.test_token(id)) {
			// Message erreur si le token de ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id + ") existe deja pour la methode login", -1);
		}

		// Verifie la creation du token est correct
		if (!Authentification_tools.creat_token_in_bd(id)) {
			// Message erreur si creat_token_in_bd ne fonctionne pas
			return ErrorJSON.serviceRefused("Probleme lors de l'insertion/creation du token de la methode login", -1);
		}

		// Acces aux informations du token
		ArrayList<String> information = Mini_tools
				.requeteGET("Select id,date_debut,date_fin From " + Authentification_tools.table + " Where id='" + id + "' ;");
		// Acces aux nom des attributs des informations
		ArrayList<String> nom_attributs = Mini_tools
				.acces_nom_attributs("Select id,date_debut,date_fin From " + Authentification_tools.table + " Where id='" + id + "' ;");

		// Creation du json
		return Mini_tools.creation_json(information, nom_attributs);
	}

	public static JSONObject logout(String id) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id)) {
			return ErrorJSON.serviceRefused("argument vide/null pour la méthode logout", -1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.exist_token(id)) {
			// Message erreur si le token n'existe dans la base de donnee
			return ErrorJSON.serviceRefused("Le token de ID(" + id + ") n'existe pas pour la methode logout", -1);
		}

		// Verifie si la supression du token est correct
		if (!Authentification_tools.logout_id(id)) {
			// Message erreur si probleme lors de la supression du token
			return ErrorJSON.serviceRefused("Probleme lors de la supression du token dans la methode logout", -1);
		}

		// Creation du json
		return ErrorJSON.serviceAccepted("ok");
	}

}
