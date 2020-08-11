package com.digitalguider.lib;

import com.digitalguider.owm.result.CurrentWeatherResults;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OpenWeatherMapDelegate {
private static final String CURRENT_LOCATION_WEATHER_URL="https://api.openweathermap.org/data/2.5/weather";
private static final String API_ID="8de9d007f1322ade09cb4379cf358698";
    public CurrentWeatherResults getCurrentWeatherDetails(String city)
    {
        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder httpBuilder = HttpUrl.parse(CURRENT_LOCATION_WEATHER_URL).newBuilder();
        httpBuilder.addQueryParameter("q",city);
        httpBuilder.addQueryParameter("appid",API_ID);
        Request request = new Request.Builder()
                .url(httpBuilder.build())
                .build();
        try (Response response = client.newCall(request).execute()) {
            return gson.fromJson(response.body().string(), CurrentWeatherResults.class);

        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args)
    {
        OpenWeatherMapDelegate delegate = new OpenWeatherMapDelegate();
        System.err.println(delegate.getCurrentWeatherDetails("allahabad"));
    }

}
