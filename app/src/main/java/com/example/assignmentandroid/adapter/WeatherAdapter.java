package com.example.assignmentandroid.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignmentandroid.MainActivity;
import com.example.assignmentandroid.R;
import com.example.assignmentandroid.modal.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {
    private final Activity activity;
    private final List<Weather> weathers;

    public WeatherAdapter(Activity activity, List<Weather> weathers) {
        this.activity = activity;
        this.weathers = weathers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View weatherView = activity.getLayoutInflater().inflate(R.layout.weather_item, parent, false);
        return new WeatherHolder(weatherView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        WeatherHolder weatherHolder = (WeatherHolder) holder;
        Weather weather = weathers.get(position);
        weatherHolder.tvTime.setText(convertTime(weather.getDateTime()));
        weatherHolder.tvTemperature.setText(weather.getTemperature().getValue().toString());
        String icon = "";
        if (weather.getWeatherIcon() < 10) {
            icon = "0" + weather.getWeatherIcon();
        } else {
            icon = "" + weather.getWeatherIcon();
        }
        String iconSrc = "https://developer.accuweather.com/sites/default/files/"+ icon +"-s.png";
        Glide.with(activity).load(iconSrc).into(weatherHolder.ivCover);
    }

    @Override
    public int getItemCount() {
        Log.d("aaa", "getItemCount: " + weathers.size());
        return weathers.size();
    }

    public String convertTime(String inputTime) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        return outFormat.format(date);
    }


    public static class WeatherHolder extends RecyclerView.ViewHolder {
        TextView tvTime, tvTemperature;
        ImageView ivCover;

        public WeatherHolder(@NonNull View itemView) {
            super(itemView);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvTemperature = itemView.findViewById(R.id.tvEx);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}
