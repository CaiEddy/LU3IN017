package test;

import services.Authentification_services;
import services.Message_services;


public class Message_test {
	public static void main(String[] args) throws Exception {
		// login de id
		int id = 1;
		Authentification_services.login("login_A","password_A");
		
		// addMessage
		System.out.println("METHODE          : Message_services.addMessage(Integer.toString("+id+"), text)");
		System.out.println("RESULTAT_ATTENDU : Chako : text");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Message_services.addMessage(Integer.toString(id),"hello tous le monde (1er message)"));
		System.out.println("\n\n");
		
		
		// addMessage
		System.out.println("METHODE          : Message_services.addMessage(Integer.toString("+id+"), text)");
		System.out.println("RESULTAT_ATTENDU : Chako : text");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Message_services.addMessage(Integer.toString(id),"on fait un test (2e message)"));
		System.out.println("\n\n");
		
		
		// listMessage
		System.out.println("METHODE          : Message_services.listMessage(Integer.toString("+id+")");
		System.out.println("RESULTAT_ATTENDU : tous les messages de id="+id);
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Message_services.listMessage(Integer.toString(id)));
		System.out.println("\n\n");

		
		// deleteMessage
		System.out.println("METHODE          : Message_services.deleteMessage(Integer.toString("+id+"),Integer.toString(2)");
		System.out.println("RESULTAT_ATTENDU : suppression du 2e message");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Message_services.deleteMessage(Integer.toString(id),Integer.toString(2)));
		System.out.println("\n\n");
		
		
		// listMessage
		System.out.println("verification que le 2e message a bien ete supprimer");
		System.out.println("METHODE          : Message_services.listMessage(Integer.toString("+id+")");
		System.out.println("RESULTAT_ATTENDU : tous les messages de id="+id);
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Message_services.listMessage(Integer.toString(id)));
		System.out.println("\n\n");
		
		// setMessage
		System.out.println("METHODE          : Message_services.setMessage(Integer.toString("+id+"),Integer.toString(1),\"je modifie le 1er message\"");
		System.out.println("RESULTAT_ATTENDU : modification du 1er message");
		System.out.println("RESULTAT_OBTENUE :");
		System.out.println(Message_services.setMessage(Integer.toString(id),Integer.toString(1),"je modifie le 1er message"));
		System.out.println("\n\n");


	}
}