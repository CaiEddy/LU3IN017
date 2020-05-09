package tools;
import org.json.JSONException;
import org.json.JSONObject;

public class ErrorJSON {
	public static JSONObject serviceRefused(String message, int codeErreur) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put(message,codeErreur);    
		return obj;
	}
	public static JSONObject serviceAccepted() {
		JSONObject obj = new JSONObject(); 
		return obj;
	}
	
}
