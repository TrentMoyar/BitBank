//import java.net.*;
//import java.io.*;
//import java.util.Scanner;

//import com.eclipsesource.json.*;
//import com.eclipsesource.json.JsonObject.Member;

/* public class Phone2ActionGETRequestCommented 
{
   public static void main(String[] args) throws IOException 
   {
      String xAPIKey = ""; 

      String endpoint = "https://fmrrixuk32.execute-api.us-east-1.amazonaws.com/hacktj/legislators";
      String parameters = "?level=NATIONAL_LOWER&address=";
      String address = "6560 Braddock Rd"; 
      String addressFormatted = URLEncoder.encode(address, "UTF-8");
      URL phone2ActionURL = new URL(endpoint + parameters + addressFormatted);

      HttpURLConnection connection = (HttpURLConnection) phone2ActionURL.openConnection();
      connection.setRequestMethod("GET"); 
      connection.setRequestProperty("X-API-Key", xAPIKey); 
      
      InputStream response = connection.getInputStream(); 
      
      Scanner scanner = new Scanner(response);
      String responseBody = scanner.useDelimiter("\\A").next();
      System.out.println(responseBody);
      scanner.close();
      
      //JsonObject responseObject = Json.parse(responseBody).asObject();
      //JsonArray responseRepresentatives = responseObject.get("officials").asArray();

      //for (JsonValue responseRepresentative : responseRepresentatives) 
      //{
      //    String firstName = responseRepresentative.asObject().get("first_name").asString();
      //    String lastName = responseRepresentative.asObject().get("last_name").asString();
      //    System.out.println("Your Representative in national Congress is " + firstName + " " + lastName);
      //}
   }
} */