package com.digitalguider.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.digitalguider.lib.OpenWeatherMapDelegate;
import com.digitalguider.owm.result.CurrentWeatherResults;

public class WeatherInfoTask extends AsyncTask<String,Void, CurrentWeatherResults>{
    @Override
    protected CurrentWeatherResults doInBackground(String... strings) {
        try {
            OpenWeatherMapDelegate delegate = new OpenWeatherMapDelegate();
            return delegate.getCurrentWeatherDetails(strings[0]);
        }catch(Exception e)
        {
            Log.e("AppError",e.getMessage());
            return null;
        }

    }
}
