package tools;

public class User_tools {
	public static String table = "db_users_cai_moukouri";
	public static String attributs = "id,login,password,prenom,nom,pseudo,mail,sexe,date_de_naissance";
	
	// login est dans la base de donnee
	public static boolean exist_login(String login) throws Exception {
		return Mini_tools.in_bd(login, "login", table);
	}
	
	// id est dans la base de donnee
	public static boolean exist_id(String id) throws Exception {
		return Mini_tools.in_bd(id, "id", table);
	}

	// creation de user
	public static boolean creation_user(String login, String password, String prenom, 
			 						 String nom, String pseudo, String mail, String sexe,
			 						 String date_de_naissance)throws Exception{
		return Mini_tools.requeteSET("INSERT INTO `DB_users_cai_moukouri` "
				+ "(`login`, `password`, `prenom`, `nom`, `pseudo`, `mail`, `sexe`, `date_de_naissance`) VALUES " +
				 "('"+login+"','"+password+"', '"+prenom+"', '"+nom+"', '"+pseudo+"', '"+mail+"', '"+sexe+"', '"+date_de_naissance+"');");
	}
	
	// delete user
	public static boolean delete_id_user(String id) throws Exception {
		return Mini_tools.requeteSET("DELETE FROM `DB_users_cai_moukouri` Where `id`="+id+";");
	}
	
}
