package com.ethanmajidi.weatherforcast.data;

import com.ethanmajidi.weatherforcast.model.Forecast;

import java.util.ArrayList;

public interface ForecastListAsyncRepsonse {
    void processFinished(ArrayList<Forecast> forecastArrayList);
}
