package tools;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.Arrays;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import BD.Static_BD;

@SuppressWarnings("unused")
public class Message_tools {
	public static int cpt = 0;

	public static boolean insert_in_bd(int id, String name, String text) {
		try {
			Document query = new Document();
			cpt++;
			query.append("id_msg", cpt);
			query.append("author_id", id);
			query.append("author_name", name);
			query.append("date", new java.util.Date());
			query.append("text", text);
			Static_BD.col.insertOne(query);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<String> getListMessage(int id_user) {
		MongoCursor<Document> cursor = null;
		// arraylist pour recuper tous les messages;
		ArrayList<String> list_message = new ArrayList<String>();
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("author_id", id_user);
		cursor = Static_BD.col.find(searchQuery).iterator();

		while (cursor.hasNext()) {
			list_message.add(cursor.next().toString());
		}

		cursor.close();
		return list_message;

	}

	public static boolean deleteMessage(int id_msg) {
		try {
			Static_BD.col.deleteOne(Filters.eq("id_msg", id_msg));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean updateMessage(int id_msg, String msg) {
		try {
			Static_BD.col.updateOne(new Document("id_msg", id_msg), new Document("$set", new Document("text", msg)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}