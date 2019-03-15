package com.example.myweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTemp = findViewById(R.id.temp);
        textViewTemp.setText(Double.toString(WeatherData.getTemp()).substring(0,4) + " С");
    }

    @Override
    protected void onStart() {
        super.onStart();
        makeToast("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeToast("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeToast("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeToast("onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeToast("onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeToast("onDestroy");
    }

    private void makeToast(String msg) {
        Log.d("Lifecycle", msg);
    }
}
