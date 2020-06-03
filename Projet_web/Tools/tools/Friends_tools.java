package tools;

import java.util.ArrayList;

public class Friends_tools {
	public static String table = "db_friends_cai_moukouri";
	public static String attributs = "id1,id2,date,nb_ami_commun";

	// id1 est ami avec id2
	public static boolean exists_friend(String id1, String id2) throws Exception {
		ArrayList<String> res = Mini_tools
				.requeteGET("Select * From " + table + " Where id1=" + id1 + " AND id2='" + id2 + "' ;");
		if (res.size() != 0)
			return true;
		return false;
	}

	// creation de l'amitie id1 vers id2
	public static boolean creation_friend(String id1, String id2) throws Exception {
		return Mini_tools.requeteSET("INSERT INTO `" + table + "` (`id1`, `id2`, `date`, `nb_ami_commun`) " + "VALUES ("
				+ id1 + "," + id2 + ", CURRENT_DATE(), '1');");
	}

	// suppression de l'amitie id1 vers id2
	public static boolean delete_friend(String id1, String id2) throws Exception {
		return Mini_tools.requeteSET("DELETE FROM `" + table + "` WHERE id1='" + id1 + "' AND id2='" + id2 + "' ;");
	}

	// mise a jour du nombre d'ami commun
	public static boolean mise_a_jour_nb_ami_commun(String id1, String id2) throws Exception {
		ArrayList<String> Liste_id_1 = Mini_tools.requeteGET("Select id2 From " + table + " Where id1='" + id1 + "' ;");
		ArrayList<String> Liste_id_2 = Mini_tools.requeteGET("Select id2 From " + table + " Where id1='" + id2 + "' ;");
		Liste_id_1.retainAll(Liste_id_2);
		int nb_commun = Liste_id_1.size();
		return Mini_tools.requeteSET("UPDATE " + table + " SET nb_ami_commun=" + nb_commun + " Where (id1='" + id1
				+ "' AND id2='" + id2 + "' )" + " OR (id1='" + id2 + "' AND id2='" + id1 + "') ;");
	}
}