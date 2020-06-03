package services;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import tools.Authentification_tools;
import tools.ErrorJSON;
import tools.Friends_tools;
import tools.Mini_tools;
import tools.User_tools;

public class Friends_services {
	// 1- Verifie si argument vide/null (si besoin)
	// 2- Verifie si le token existe dans la BD (si besoin)
	// 3- Test parametres (si besoin)
	// 4- Recupere les informations + creation/return du JSON

	public static JSONObject addFriend(String id1, String id2) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id1) || Mini_tools.null_vide(id2)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode addFriend", -1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id1)) {
			// Message erreur si le token de ID est inconnu par la base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id1 + ") n'existe pas pour la methode addFriend", -1);
		}

		// Verifie si la relation id1 vers id2 existe deja
		if (Friends_tools.exists_friend(id1, id2)) {
			// Message erreur si id1 est deja ami avec id2
			return ErrorJSON
					.serviceRefused("id(" + id1 + ") est deja l'ami de  id(" + id2 + ") pour la methode addFriend", 1);
		}

		// Verifie si la creation de la relation de id1 vers id2 dans la base de donnee
		// se fait correctement
		if (!Friends_tools.creation_friend(id1, id2)) {
			// Message erreur si probleme lors de l'insertion
			return ErrorJSON.serviceRefused("erreur d'insertion dans la table pour la methode addFriend", 1);
		}

		// Verifie si la mise a jour des nb ami commun se fait correct
		if (!Friends_tools.mise_a_jour_nb_ami_commun(id1, id2)) {
			// Message erreur si probleme lors de la mise a jour des nombres amis
			return ErrorJSON.serviceRefused(
					"erreur lors de la mise a jour des nombres amis commun dans la table pour la methode addFriend", 1);
		}

		// Acces aux informations de la relation
		ArrayList<String> information = Mini_tools.requeteGET(
				"Select * From " + Friends_tools.table + " Where id1='" + id1 + "' AND id2='" + id2 + "' ;");
		// Acces aux nom des attributs des informations
		ArrayList<String> nom_attributs = Mini_tools.acces_nom_attributs(
				"Select * From " + Friends_tools.table + " Where id1='" + id1 + "' AND id2='" + id2 + "' ;");

		// Creation du json
		return Mini_tools.creation_json(information, nom_attributs);

	}

	public static JSONObject deleteFriend(String id1, String id2) throws JSONException, Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id1) || Mini_tools.null_vide(id2)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode deleteFriend", -1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id1)) {
			// Message erreur si le token de ID est inconnu parla base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id1 + ") n'existe pas pour la methode deleteFriend", -1);
		}

		// Verifie si la relation id1 vers id2 existe
		if (!(Friends_tools.exists_friend(id1, id2))) {
			// Message erreur si la relation id1 vers id2 n'existe pas
			return ErrorJSON.serviceRefused(
					"id(" + id1 + ") n'est pas ami avec id(" + id2 + ") pour la methode deleteFriend", 1);
		}

		// Verifie si la suppression de la relation id1 vers id2 fonctionne
		if (!Friends_tools.delete_friend(id1, id2)) {
			// Message erreur si erreur lors de la suppression
			return ErrorJSON.serviceRefused("erreur de suppression dans la table pour la methode deleteFriend", 1);
		}

		// Verifie si la mise a jours des nb ami commun se fait correct
		if (!Friends_tools.mise_a_jour_nb_ami_commun(id1, id2)) {
			// Message erreur si probleme lors de la mise a jour des nombres amis
			return ErrorJSON.serviceRefused(
					"erreur lors de la mise a jour des nombres amis commun dans la table pour la methode deleteFriend",
					1);
		}

		// Creation du json
		return ErrorJSON.serviceAccepted("ok");
	}

	public static JSONObject getFriendList(String id) throws Exception {

		// Verifie si un argument est vide ou null
		if (Mini_tools.null_vide(id)) {
			// Message erreur si arguement vide ou null
			return ErrorJSON.serviceRefused("argument vide/null pour la methode getFriendList", -1);
		}

		// Verifie si le token existe
		if (!Authentification_tools.test_token(id)) {
			// Message erreur si le token de ID est inconnu parla base de donnee
			return ErrorJSON.serviceRefused("Le TOKEN de l'ID(" + id + ") n'existe pas pour la methode getFriendList", -1);
		}

		// Acces aux informations des relations d'id
		ArrayList<String> information = Mini_tools.requeteGET("Select id2,pseudo " + "From " + User_tools.table + ","
				+ Friends_tools.table + " " + "Where " + Friends_tools.table + ".id2=" + User_tools.table + ".id "
				+ "AND " + Friends_tools.table + ".id1='" + id + "' ;");
		// Acces aux nom des attributs des informations
		ArrayList<String> nom_attributs = Mini_tools.acces_nom_attributs("Select id2,pseudo " + "From "
				+ User_tools.table + "," + Friends_tools.table + " " + "Where " + Friends_tools.table + ".id2="
				+ User_tools.table + ".id " + "AND " + Friends_tools.table + ".id1='" + id + "' ;");

		// Creation du json
		return Mini_tools.creation_json(information, nom_attributs);
	}

}