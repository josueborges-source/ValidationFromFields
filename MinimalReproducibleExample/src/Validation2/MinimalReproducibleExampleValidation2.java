package Validation2;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class MinimalReproducibleExampleValidation2 {

	public static void main(String[] args) {		

		JSONObject jsonObject = new JSONObject();

	        try {
	        	jsonObject.put("name", "John Doe");
	        	jsonObject.put("occupation", "gardener");
	        	jsonObject.put("siblings", Integer.valueOf(2));
	        	jsonObject.put("height", Double.valueOf(172.35));
	        	jsonObject.put("married", Boolean.TRUE);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        var userJson = jsonObject.toString();

	        System.out.println(userJson);	    
	}

}
