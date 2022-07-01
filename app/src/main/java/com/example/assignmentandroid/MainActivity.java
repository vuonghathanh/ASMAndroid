package com.example.assignmentandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.assignmentandroid.adapter.WeatherAdapter;
import com.example.assignmentandroid.api.ApiManager;
import com.example.assignmentandroid.modal.Weather;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvWeather;
    TextView tvStatus, tvTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvWeather = findViewById(R.id.rvWeather);
        tvStatus = findViewById(R.id.tvStatus);
        tvTemperature = findViewById(R.id.tvTemperature);
        callApi();
    }


    public void callApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiManager.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiManager apiManager = retrofit.create(ApiManager.class);
        apiManager.getWeather12House().enqueue(new Callback<List<Weather>>() {
            @Override
            public void onResponse(Call<List<Weather>> call, Response<List<Weather>> response) {
                if (response.body() != null) {
                    List<Weather> weathers = response.body();
                    tvStatus.setText(weathers.get(0).getIconPhrase());
                    tvTemperature.setText(weathers.get(0).getTemperature().getValue().toString());

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    rvWeather.setLayoutManager(layoutManager);

                    WeatherAdapter adapter = new WeatherAdapter(MainActivity.this, weathers);
                    rvWeather.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Weather>> call, Throwable t) {
                Log.d("MainActivity", "onFailure: " + t);
            }
        });
    }
}