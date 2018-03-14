package com.example.guessinggame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView statusText;
    private EditText guessField;
    private int secretNumber;
    Button button;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = getSharedPreferences("value",MODE_PRIVATE);
        int max = preferences.getInt("max bar",10);
        int min = preferences.getInt("min bar",0);




        Random random = new Random();
        secretNumber = min+ random.nextInt(max);

        statusText = (TextView) findViewById(R.id.statusText);
        guessField = (EditText) findViewById(R.id.guessField);

        statusText.setText("Try your best");





        guessField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence string, int start, int before, int count) {
                try {
                    int value = Integer.parseInt(string.toString());

                    if (value == secretNumber) {
                        statusText.setText("you won!! you are the king of java");
                    }
                    if (value > secretNumber) {
                        statusText.setText("lower my son");
                    }
                    if (value < secretNumber) {
                        statusText.setText("higher my son");
                    }
                } catch (Exception e){

                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("done....");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        int max = preferences.getInt("max bar",10);
        int min = preferences.getInt("min bar",0);




        Random random = new Random();
        secretNumber = min+ random.nextInt(max-min);

        statusText = (TextView) findViewById(R.id.statusText);
        guessField = (EditText) findViewById(R.id.guessField);

        statusText.setText("Try your best. min= "+min+" max = "+ max +" the secret number is "+secretNumber);


    }

    public void settings(View view) {
        Intent openSettings = new Intent (this,SettingsActivity.class);
        startActivity(openSettings);

    }
}
