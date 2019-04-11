package com.example.test2;

import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConnectInit extends AsyncTask<String, String, String> {
    protected String doInBackground(String... values) {
        try {
            String toReturn = "";
            String value = values[0];
            URL bitBankURL = new URL(value);
            HttpURLConnection connection = (HttpURLConnection) bitBankURL.openConnection();
            connection.connect();
            connection.setRequestMethod("GET");
            //connection.setRequestProperty("X-API-Key", values[1]);
            InputStream response = connection.getInputStream();
            Scanner scanner = new Scanner(response);
            String responseBody = scanner.useDelimiter("\\A").next();
            JsonObject marketObject = Json.parse(responseBody).asObject();
            scanner.close();
            JsonArray marketValues = marketObject.get("rates").asArray();

            for(JsonValue marketValue : marketValues) {
                String time = marketValue.asObject().get("time").asString();
                String asset = marketValue.asObject().get("asset_id_quote").asString();
                String rate = marketValue.asObject().get("rate") + "";
                if(asset.equals(values[2])) {
                    return rate;
                }

            }

            return "";
        } catch (Exception e) {
            return e.getCause() + "";
        }
    }
}
