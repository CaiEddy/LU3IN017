package BD;

import java.sql.*;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Static_BD {
	public static final String mysql_host = "jdbc:mysql://localhost/vene";
 	public static final String mysql_bd = "BD_CAI_MOUKOURI";
	public static final String mysql_user = "root";
	public static final String mysql_password = "";
	public static final boolean mysql_pooling = false;
	public static Connection com;
	public static Statement st;
	public static final MongoClientURI connectionString = new MongoClientURI("mongodb://127.0.0.1:27017");
	public static final MongoClient mongoClient = new MongoClient(connectionString);
	public static final MongoDatabase database = mongoClient.getDatabase("DB_cai_moukouri");
	public static final MongoCollection<Document> col = database.getCollection("test");
}
