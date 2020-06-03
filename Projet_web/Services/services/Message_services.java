package services;

import java.util.ArrayList;

import org.json.JSONObject;
import tools.Authentification_tools;
import tools.ErrorJSON;
import tools.Message_tools;
import tools.Mini_tools;
import tools.User_tools;

public class Message_services {
	// 1- Verifie si argument vide/null (si besoin)
	// 2- Verifie si le token existe dans la BD (si besoin)
	// 3- Test parametres (si besoin)
	// 4- Recupere les informations + creation/return du JSON
	public static JSONObject addMessage(String id, String text) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(text)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode addMessage", -1);
		}

		// Verifie si ID existe
		if (!User_tools.exist_id(id)) {
			// Message erreur si ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("L'utilisateur ID(" + id + ") n'existe pas pour la methode addMessage", -1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id)) {
			// Message erreur si le token de ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id + ") n'existe pas pour la methode addMessage", -1);
		}

		// on récupère le pseudo de l'id
		ArrayList<String> pseudo_list = Mini_tools
				.requeteGET("Select pseudo From " + User_tools.table + " Where id='" + id + "' ;");
		String pseudo = pseudo_list.get(0);

		// on insert le message dans mongodb
		if (!Message_tools.insert_in_bd(Integer.parseInt(id), pseudo, text)) {
			// Message erreur si problème lors de l'insertion dans mongo
			return ErrorJSON.serviceRefused("erreur d'insertion dans mongodb pour la methode addMessage", 1);
		}

		// Creation du json
		return ErrorJSON.serviceAccepted(pseudo + " : " + text);

	}

	public static JSONObject deleteMessage(String id_user, String id_msg) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id_user) || Mini_tools.null_vide(id_msg)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode deleteMessage", -1);
		}

		// Verifie si ID existe
		if (!User_tools.exist_id(id_user)) {
			// Message erreur si ID est inconnu par la base de donnee
			return ErrorJSON
					.serviceRefused("L'utilisateur ID(" + id_user + ") n'existe pas pour la methode deleteMessage", -1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id_user)) {
			// Message erreur si le token de ID est inconnu par la base de donnee
			return ErrorJSON
					.serviceRefused("Le TOKEN de l'ID(" + id_user + ") n'existe pas pour la methode deleteMessage", -1);
		}

		// Verifie la suppression du message
		if (!Message_tools.deleteMessage(Integer.parseInt(id_msg))) {
			return ErrorJSON.serviceRefused("la suppression du message a echoue pour la methode deleteMessage", -1);
		}

		// Creation du json
		return ErrorJSON.serviceAccepted("Message supprime (ok)");

	}

	public static JSONObject listMessage(String id) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode listMessage", -1);
		}

		// Verifie si ID existe
		if (!User_tools.exist_id(id)) {
			// Message erreur si ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("L'utilisateur ID(" + id + ") n'existe pas pour la methode listMessage",
					-1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id)) {
			// Message erreur si le token de ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id + ") n'existe pas pour la methode listMessage",
					-1);
		}

		// on récupère le pseudo de l'id
		ArrayList<String> pseudo_list = Mini_tools
				.requeteGET("Select pseudo From " + User_tools.table + " Where id='" + id + "' ;");
		// Acces a tous les messages provenant de id
		ArrayList<String> message_list = Message_tools.getListMessage(Integer.parseInt(id));


		// Creation du json
		return Mini_tools.creation_json(message_list, pseudo_list);

	}

	public static JSONObject setMessage(String id_user, String id_msg, String text) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id_user) || Mini_tools.null_vide(id_msg) || Mini_tools.null_vide(text)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode setMessage", -1);
		}

		// Verifie si ID existe
		if (!User_tools.exist_id(id_user)) {
			// Message erreur si ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("L'utilisateur ID(" + id_user + ") n'existe pas pour la methode setMessage",
					-1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id_user)) {
			// Message erreur si le token de ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id_user + ") n'existe pas pour la methode setMessage",
					-1);
		}

		// Verifie la suppression du message
		if (!Message_tools.updateMessage(Integer.parseInt(id_msg), text)) {
			return ErrorJSON.serviceRefused("la modification du message a echoue pour la methode setMessage", -1);
		}

		// on récupère le pseudo de l'id
		ArrayList<String> pseudo_list = Mini_tools
				.requeteGET("Select pseudo From " + User_tools.table + " Where id='" + id_user + "' ;");
		String pseudo = pseudo_list.get(0);

		// Creation du json
		return ErrorJSON.serviceAccepted(pseudo + " : " + text + " (modifier)");

	}

}
