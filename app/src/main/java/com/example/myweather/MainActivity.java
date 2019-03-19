package com.example.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextCity;
    private Button button;
    private SwitchCompat switchCompat;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // определяем наши элементы
        editTextCity = findViewById(R.id.name_city);
        button = findViewById(R.id.btn_show_weather);
        switchCompat = findViewById(R.id.btn_is_show);

        // задаем слушатель нашей кнопки
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherData wd = WeatherData.getInstance();
                wd.setCity(editTextCity.getText().toString());
                wd.setIsShow(switchCompat.isChecked());
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("dataWeather", wd);
                startActivity(intent);
            }
        });

        // очистка текстового поля editTextCity
        editTextCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextCity.setText("");
            }
        });
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
        Log.d("MainActivity.Lifecycle", msg);
    }
}
