package com.example.myweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private SwitchCompat switchCompat;

    private static String NULL_TEXT = "";
    private static String TEXT_INPUT_NAME_CITY = "Введите название города";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // задаем слушатель нашей кнопки
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeatherData wd = WeatherData.getInstance();
                try {
                    if (editText.getText().toString().equals(NULL_TEXT) || editText.getText().toString().equals(TEXT_INPUT_NAME_CITY)) {
                        throw new IONullException();
                    }
                    else {
                        initWeatherDate(wd);
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("dataWeather", wd);
                        startActivity(intent);
                    }
                }catch (IOException e) {
                    makeToast("Введите название города!");
                }
            }
        });

        // очистка текстового поля editText
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void makeToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }

    private void initView(){
        // определяем наши элементы
        editText = findViewById(R.id.name_city);
        button = findViewById(R.id.btn_show_weather);
        switchCompat = findViewById(R.id.btn_is_show);
    }

    private void initWeatherDate(WeatherData wd){
        wd.setCity(editText.getText().toString());
        wd.setIsShow(switchCompat.isChecked());
    }
}
