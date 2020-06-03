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
		ArrayList<String> res = Mini_tools.requeteGET("Select * From " + table + " Where id='" + id + "' ;");
		if (res.size() != 0)
			return true;
		return false;
	}

	public static boolean logout_id(String id) throws Exception {
		if (Mini_tools.requeteSET("DELETE FROM `" + table + "` WHERE `" + table + "`.`id`='" + id + "' ;")) {
			return true;
		}
		return false;
	}

	public static void time_over_token_delete() throws Exception {
		ArrayList<String> res = Mini_tools.requeteGET(
				"Select id From " + table + " Where CURRENT_TIMESTAMP NOT BETWEEN date_debut AND date_fin ;");
		for (String i : res) {
			Mini_tools.requeteSET("DELETE FROM `" + table + "` WHERE `" + table + "`.`id`='" + i + "' ;");
		}
	}

	public static boolean mise_a_jour_date(String id) throws Exception {
		if (Mini_tools.requeteSET("UPDATE " + table
				+ " SET date_debut = CURRENT_TIMESTAMP, date_fin = CURRENT_TIMESTAMP+'1000' Where id='" + id + "' ;")) {
			return true;
		}
		return false;
	}

	public static boolean creat_token_in_bd(String id) throws Exception {
		if (Mini_tools.requeteSET("INSERT INTO `" + table + "` (`id`, `token`, `date_debut`, `date_fin`) VALUES ('1', '"
				+ generation_token() + "', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP+'1000');")) {
			return true;
		}
		return false;
	}

	public static boolean test_token(String id) throws Exception {
		time_over_token_delete();
		if (exist_token(id)) {
			return mise_a_jour_date(id);
		}
		return false;
	}

}

