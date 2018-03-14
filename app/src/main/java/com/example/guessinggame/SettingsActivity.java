package com.example.guessinggame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private TextView MinNumber;
    private TextView MaxNumber;
    private SeekBar MinBar;
    private SeekBar MaxBar;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        MinNumber = (TextView) findViewById(R.id.MinNumber);
        MinBar = (SeekBar) findViewById(R.id.MinBar);
        MaxNumber = (TextView) findViewById(R.id.MaxNumber);
        MaxBar = (SeekBar) findViewById(R.id.MaxBar);
        preferences = getSharedPreferences("value",MODE_PRIVATE);
        //MinBar.setProgress(0);
        //MaxBar.setProgress(10);
        MinBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                MinNumber.setText(String.valueOf(i));
                System.out.println(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        MaxBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                MaxNumber.setText(String.valueOf(i));
                System.out.println(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        int maxProgress = preferences.getInt("max bar",10);
        MaxBar.setProgress(maxProgress);
        int minProgress = preferences.getInt("min bar",0);
        MinBar.setProgress(minProgress);
        Log.i("Secondary","on start called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Secondary","on stop called");

        preferences.edit().putInt("max bar",MaxBar.getProgress())
                .apply();
        preferences.edit().putInt("min bar",MinBar.getProgress())
                .apply();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Secondary","on destroy called");
    }
}
