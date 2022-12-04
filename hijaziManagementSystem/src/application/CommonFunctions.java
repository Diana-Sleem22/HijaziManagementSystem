package application;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommonFunctions {
	public static   JSONObject sendHTTPRequest(String targetURL,String requestMethod, String urlParameters, String body) throws IOException, ParseException {
		JSONArray jsonArray = null;
		StringBuilder stringBuilder = new StringBuilder();
		  String jsonString = "";
		URL obj = new URL(targetURL);
		  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 
		        // Setting basic post request
		  con.setRequestMethod(requestMethod);
		  con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		  con.setRequestProperty("Content-Type","application/json");
		 
		 
		  // Send post request
		  con.setDoOutput(true);
		  if(requestMethod.equals("POST")) {
			  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			  wr.writeBytes(body);
			  wr.flush();
			  wr.close();
		  }
		 
		  int responseCode = con.getResponseCode();
		  System.out.println("nSending " + requestMethod + " request to URL : " + targetURL);
		  System.out.println("Post Data : " + body);
		  System.out.println("Response Code : " + responseCode);
		 
		  BufferedReader in = new BufferedReader(
		          new InputStreamReader(con.getInputStream()));
		  String output;
		  StringBuffer response = new StringBuffer();
		 
		  if(requestMethod.equals("GET")) {
			  while ((output = in.readLine()) != null) {
				   response.append(output);
					    stringBuilder.append(output + '\n');
				  }
				 
				  jsonString = stringBuilder.toString();
				  JSONParser parser = new JSONParser();
				  Object object = (Object) parser.parse(jsonString);
		           jsonArray = (JSONArray) object;
				  in.close();
		  }
		  JSONObject data= new JSONObject();
		  data.put("responseCode",responseCode);
		  data.put("data",jsonArray);
		  //printing result from response
//		  System.out.println(response.toString());
		return data;
		}	
}
