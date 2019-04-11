// We import some standard Java classes to make our HTTP Request
import com.example.test2.*;

import java.net.*;
import java.io.*;
import java.util.Scanner;

// This is the Minimal JSON package, which we've added as a dependency
// It converts the JSON we get from the HTTP Request to a useable format
// Documentation for this package here: https://github.com/ralfstx/minimal-json

public class WikipediaGETRequest {
   public static void main(String[] args) throws IOException {
      // First, we construct the URL we'll make our HTTP GET Request to:
      String baseAPI = "https://en.wikipedia.org/w/api.php";
      String parameters = "?format=json&action=query&redirects=1&prop=extracts&exintro=1&explaintext=1&titles=";
      String articleTitle = "tjhsst"; // This can be any article title!
      String articleTitleFormatted = URLEncoder.encode(articleTitle, "UTF-8"); // This formats the article title for our URL
      URL wikipediaURL = new URL(baseAPI + parameters + articleTitleFormatted); // This is the Java URL class, necessary here

      // Then, we set up the HTTP GET Request itself
      HttpURLConnection connection = (HttpURLConnection) wikipediaURL.openConnection();
      connection.setRequestMethod("GET"); // We need to set the HTTP Request type!
      connection.setRequestProperty("Content-Type", "application/json"); // This tells Wikipedia to return a JSON (again)
      
      // Now, we're able to fire the configured HTTP GET Request with the getInputStream() method
      InputStream response = connection.getInputStream(); // The HttpURLConnection's response is an InputStream
      
      // Next, we convert the response to a JsonObject with Minimal JSON
      Scanner scanner = new Scanner(response);
      String responseBody = scanner.useDelimiter("\\A").next(); // The response is a String, which isn't useful
      JsonObject responseObject = Json.parse(responseBody).asObject(); // This converts it to a (useful) JsonObject
      scanner.close();

      // Finally, we pick out the data we want and print it to the console
      // Use Postman to figure out what format your data is in and access it accordingly
      JsonObject responsePages = responseObject.get("query").asObject().get("pages").asObject();
      // We don't know what each of the keys of the response's pages will be, so we loop through all of them
      for (JsonObject.Member responsePageMember : responsePages) { // Each key is a Member object, provided by Minimal JSON
         JsonObject responsePageObject = responsePageMember.getValue().asObject(); // We convert the key's value to a JsonObject
         String fullTitle = responsePageObject.get("title").asString();
         System.out.println("Full Title: " + fullTitle);
         System.out.println();
         String introduction = responsePageObject.get("extract").asString();
         System.out.println("Introduction: " + introduction.replaceAll("\n", " "));
         System.out.println();
      }
   }
}

