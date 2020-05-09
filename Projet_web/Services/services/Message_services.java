package services;

import org.json.JSONObject;
import tools.ErrorJSON;

public class Message_services {
	public static JSONObject addMessage(String text) {
		// INSERER LE MESSAGE DANS LA BD
		JSONObject obj = ErrorJSON.serviceAccepted();
		return obj;
	}
	
	public static JSONObject deleteMessage(String text) {
		// DELETE LE MESSAGE DANS LA BD
		JSONObject obj = ErrorJSON.serviceAccepted();
		return obj;
	}
	
	public static JSONObject listMessage(int id) {
		// ACCEDER A LA BD POUR RECUPERER LES MESSAGES DE LA PERSONNE ID
		JSONObject obj = ErrorJSON.serviceAccepted();
		return obj;
	}

}
