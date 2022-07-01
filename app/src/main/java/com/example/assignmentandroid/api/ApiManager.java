package com.example.assignmentandroid.api;

import com.example.assignmentandroid.modal.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiManager {
    String API_KEY = "azBMPalwDz9MVASskTBGkcKavC8kEckr";
    String API_URL = "https://dataservice.accuweather.com/forecasts/v1/hourly/12hour/";
    String LANGUAGE = "vi-vn";
    String METRIC = "true";

//    @GET("forecasts/v1/hourly/12hour/353412?apiKey=" + API_KEY + "&language=" + LANGUAGE + "&metric=" + METRIC)
    @GET("353412?apikey=azBMPalwDz9MVASskTBGkcKavC8kEckr&language=vi-vn&metric=true")
    Call<List<Weather>> getWeather12House();
}