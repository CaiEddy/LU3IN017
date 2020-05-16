package BD;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion_BD {	

	public static void open_connexion_BD() throws SQLException {
		String URL = Static_BD.mysql_host+Static_BD.mysql_bd;
		Static_BD.com = DriverManager.getConnection(URL,Static_BD.mysql_user,Static_BD.mysql_password);
	}
	
	
	public static void close_connexion_BD() throws SQLException {
		Static_BD.com.close();
	}

}
