package tools;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Authentification_tools {
	public static String table = "db_authentification_cai_moukouri";
	public static String attributs = "id,token,date_debut,date_fin";
	

	public static String generation_token() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		String token = bytes.toString();
		return token;
	}
	
	
	public static boolean exist_token(String id) throws Exception {
		ArrayList<String> res = Mini_tools.requeteGET("Select * From "+table+" Where id='"+id+"' ;");
		if (res.size() != 0) return true;
		return false;
	}
	
	public static boolean time_is_over(String id) throws Exception {
		ArrayList<String> res = Mini_tools.requeteGET("Select * From "+table+" Where id="+id+" AND CURRENT_TIMESTAMP BETWEEN date_debut AND date_fin ;");                 
		if(res.size() != 0) return false;
		return true;
	}
	
	public static boolean logout_id(String id) throws Exception {
		if(Mini_tools.requeteSET("DELETE FROM `"+table+"` WHERE `"+table+"`.`id`='"+id+"' ;")) {
			return true;
		}
		return false;
	}
	
	
	public static boolean mise_a_jour_date(String id) throws Exception {
		if(Mini_tools.requeteSET("UPDATE "+table+" SET date_debut = CURRENT_TIMESTAMP, date_fin = CURRENT_TIMESTAMP+'1000' Where id='"+id+"' ;")) {
			return true;
		}
		return false;
	}
	
	
	public static boolean creat_token_in_bd(String id) throws Exception {
		if(Mini_tools.requeteSET("INSERT INTO `"+table+"` (`id`, `token`, `date_debut`, `date_fin`) VALUES ('1', '"+generation_token()+"', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP+'1000');")) {
			return true;
		}
		return false;
	}
	
	public static boolean test_token(String id) throws Exception {
		if(exist_token(id)) {
			if(time_is_over(id)) {
				return false;
				}
			return mise_a_jour_date(id);
		}
		return false;
	}
	
	
}

