package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.test2.MESSAGE";
    private static final String xAPIKey = "C0BD78E4-265C-43A7-A7E7-FFCB7375B7D5";
    private static String dataType = "";
    private static String endpoint = "https://rest.coinapi.io/v1/exchangerate/";
    private static String toReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendMessage(View view) throws Exception {
        // Do something in response to button
        toReturn = "";
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();

        dataType = message;

        endpoint += dataType + "?apikey=";
        String temp = endpoint + xAPIKey;

        ConnectInit init = new ConnectInit();
        init.execute(temp, xAPIKey, editText2.getText().toString());
        String tor = init.get();


        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, tor);
        startActivity(intent);

    }


}
