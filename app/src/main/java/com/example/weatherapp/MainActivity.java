package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;

    private RecyclerView recyclerViewHorizontal, recyclerViewHorizontalSmall, recyclerViewVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        applyEdgeToEdge();

        initializeRecyclerViews();
    }

    private void applyEdgeToEdge() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            v.setPadding(insets.getInsets(WindowInsetsCompat.Type.systemBars()).left,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).top,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).right,
                    insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom);
            return insets;
        });

        button = findViewById(R.id.weather_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), HomeWeather.class);
                startActivity(i);
            }

        });

    }

    private void initializeRecyclerViews() {
        recyclerViewHorizontal = findViewById(R.id.recycler_view_horizontal);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHorizontal.setAdapter(new CardAdapter(createCardItems()));

        recyclerViewHorizontalSmall = findViewById(R.id.recycler_view_horizontal_small);
        recyclerViewHorizontalSmall.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewHorizontalSmall.setAdapter(new SmallCardAdapter(createSmallCardItems()));

        recyclerViewVertical = findViewById(R.id.recycler_view_vertical);
        recyclerViewVertical.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewVertical.setAdapter(new VerticalCardAdapter(createVerticalCardItems()));
    }

    private List<CardItems> createCardItems() {
        List<CardItems> items = new ArrayList<>();
        items.add(new CardItems(R.drawable._102326_cloud_sun_sunny_weather_icon, "Travelling Sites", "Places to travel to", "We provide places to travel"));
        items.add(new CardItems(R.drawable._102328_hot_sun_weather_icon, "IT Services", "IT experts available", "We have IT experts"));
        items.add(new CardItems(R.drawable._102320_cloud_heavy_rain_rain_weather_icon, "IT Services", "IT experts available", "We have IT experts"));
        items.add(new CardItems(R.drawable._102315_cloud_weather_icon, "IT Services", "IT experts available", "We have IT experts"));
        items.add(new CardItems(R.drawable._102314_cloud_cloudy_sun_sunny_weather_icon, "IT Services", "IT experts available", "We have IT experts"));
        return items;
    }

    private List<CardItems> createSmallCardItems() {
        List<CardItems> items = new ArrayList<>();
        items.add(new CardItems(R.drawable._102326_cloud_sun_sunny_weather_icon, "Small Title 1", "", ""));
        items.add(new CardItems(R.drawable._102328_hot_sun_weather_icon, "Small Title 2", "", ""));
        items.add(new CardItems(R.drawable._102320_cloud_heavy_rain_rain_weather_icon, "Small Title 1", "", ""));
        items.add(new CardItems(R.drawable._102314_cloud_cloudy_sun_sunny_weather_icon, "Small Title 1", "", ""));
        items.add(new CardItems(R.drawable._102315_cloud_weather_icon, "Small Title 1", "", ""));
        items.add(new CardItems(R.drawable._102315_cloud_weather_icon, "Small Title 1", "", ""));
        items.add(new CardItems(R.drawable._102328_hot_sun_weather_icon, "Small Title 1", "", ""));
        items.add(new CardItems(R.drawable._102326_cloud_sun_sunny_weather_icon, "Small Title 1", "", ""));
        return items;
    }

    private List<CardItems> createVerticalCardItems() {
        List<CardItems> items = new ArrayList<>();
        items.add(new CardItems(R.drawable._102315_cloud_weather_icon, "Vertical Title 1", "Subtitle 1", "Description 1"));
        items.add(new CardItems(R.drawable._102314_cloud_cloudy_sun_sunny_weather_icon, "Vertical Title 1", "Subtitle 1", "Description 1"));
        items.add(new CardItems(R.drawable._102326_cloud_sun_sunny_weather_icon, "Vertical Title 1", "Subtitle 1", "Description 1"));
        items.add(new CardItems(R.drawable._102320_cloud_heavy_rain_rain_weather_icon, "Vertical Title 1", "Subtitle 1", "Description 1"));
        items.add(new CardItems(R.drawable._102315_cloud_weather_icon, "Vertical Title 1", "Subtitle 1", "Description 1"));
        items.add(new CardItems(R.drawable._102328_hot_sun_weather_icon, "Vertical Title 1", "Subtitle 1", "Description 1"));

        return items;
    }



}
