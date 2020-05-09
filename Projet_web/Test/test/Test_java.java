package test;
import org.json.JSONException;
import org.json.JSONObject;

import services.Authentification_services;
import services.Friends_services;
import tools.Authentification_tools;

public class Test_java {
	public static void main(String[] args) throws Exception {
		//System.out.println(Authentification_services.login("Chako", "luludu38"));
		
		System.out.println(Authentification_tools.test_token("1"));
		//System.out.println(Authentification_services.logout("1"));
		return;
	}
}