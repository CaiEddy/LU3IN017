package BD;

import java.sql.*;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Static_BD {
	public static final String mysql_host = "jdbc:mysql://localhost/";
 	public static final String mysql_bd = "bd_cai_moukouri";
	public static final String mysql_user = "root";
	public static final String mysql_password = "";
	public static final boolean mysql_pooling = false;
	public static Connection com;
	public static Statement st;
	
	public static final String mongo_host = "mongodb://127.0.0.1:27017";
	public static final String mongo_bd = "Mongo_CAI_MOUKOURI";
	public static final String mongo_collection = "Message_CAI_MOUKOURI";
	public static MongoClientURI URL = new MongoClientURI(Static_BD.mongo_host);
	public static MongoClient mongoClient = new MongoClient(URL);
	public static MongoDatabase database = mongoClient.getDatabase(Static_BD.mongo_bd);
	public static MongoCollection<Document> col = database.getCollection(Static_BD.mongo_collection);
	
}
