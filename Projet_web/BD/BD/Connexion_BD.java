package BD;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connexion_BD {	

	public static void open_connexion_BD() throws SQLException {
		String URL = Static_BD.mysql_host;
		Static_BD.com = DriverManager.getConnection(URL,Static_BD.mysql_user,Static_BD.mysql_password);
	}
	
	public static void close_connexion_BD() throws SQLException {
		Static_BD.com.close();
	}
	
	public static void open_conn_mongoDB() {
		MongoClientURI URL = Static_BD.connectionString ;
		MongoClient mongoClient = new MongoClient(URL);
		MongoDatabase database = mongoClient.getDatabase("DB_eddy");
		MongoCollection<Document> col = database.getCollection("test");
	}

	public static void close_conn_mongoDB() {
		Static_BD.mongoClient.close();
	}

}
