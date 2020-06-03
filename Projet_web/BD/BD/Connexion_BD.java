package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion_BD {

	public static Connection open_connexion_BD() throws Exception {
		String URL = Static_BD.mysql_host + Static_BD.mysql_bd;
		Class.forName("com.mysql.jdbc.Driver");
		Connection com = DriverManager.getConnection(URL, Static_BD.mysql_user, Static_BD.mysql_password);
		return com;
	}

	public static void close_connexion_BD(Connection com) throws SQLException {
		com.close();
	}

}
