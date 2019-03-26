package com.example.myweather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView nameCity;
    private TextView temp;
    private TextView typeWeather;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        WeatherData wd = (WeatherData) getIntent().getExtras().getSerializable("dataWeather");
        // инициальзруем View
        initView(wd);
        // проверяем хочет ли пользователь видеть подробную информацию
        if (wd.getIsShow()) { showAll(wd); }
    }

    private void initView(WeatherData wd){
        // определяем наши элементы
        nameCity = findViewById(R.id.name_city);
        temp = findViewById(R.id.temp);
        typeWeather = findViewById(R.id.type_weather);
        imageView = findViewById(R.id.type_weather_img);

        // скрываем подробную информацию
        typeWeather.setVisibility(View.INVISIBLE);
        imageView.setVisibility(View.INVISIBLE);

        // передаем необходимую информацию каждому элементу
        nameCity.setText(String.valueOf(wd.getCity()));
        temp.setText(String.valueOf(wd.getTemp()).substring(0,4) + " C");

    } // инициализация текущего View

    private void showAll(WeatherData wd){
        typeWeather.setVisibility(View.VISIBLE);
        typeWeather.setText(String.valueOf(wd.getType()));

        imageView.setVisibility(View.VISIBLE);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.rain, getTheme()));
    } // показать подробную информацию
}
