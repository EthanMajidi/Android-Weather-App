package com.ethanmajidi.weatherforcast.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.ethanmajidi.weatherforcast.controller.AppController;
import com.ethanmajidi.weatherforcast.model.Forecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ForecastData {
    ArrayList<Forecast> forecastArrayList = new ArrayList<>();
    String urlLeft = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22";
    String urlRight = "%22)%20and%20u%3D%22c%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";


    //String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22toronto%2canada%22)%20and%20u%3D%22c%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    public void getForecast( final ForecastListAsyncRepsonse callback, String locationText){
        String url = urlLeft + locationText + urlRight;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {



                    JSONObject query = response.getJSONObject("query");
                    JSONObject results = query.getJSONObject("results");
                    JSONObject channel = results.getJSONObject("channel");

                    JSONObject location = channel.getJSONObject("location");






                    //Item object
                    JSONObject itemObject = channel.getJSONObject("item");


                    //condition object
                    JSONObject conditionObject = itemObject.getJSONObject("condition");
                    //forecast.setDate(conditionObject.getString("date"));
                    //forecast.setCurrentTemperature(conditionObject.getString("temp"));
                    //forecast.setCurrentWeatherDescription(conditionObject.getString("text"));

                    //Forecast JsonArray
                    JSONArray forecastArray = itemObject .getJSONArray("forecast");
                    for (int i = 0; i < forecastArray.length(); i++){
                        JSONObject forecastObject = forecastArray.getJSONObject(i);
                        Forecast forecast = new Forecast();

                            //forecast.setForecastDate(forecastObject.getString("date"));
                            forecast.setForecastDay(forecastObject.getString("day"));
                            forecast.setForecastHighTemp(forecastObject.getString("high"));
                            forecast.setForecastLowTemp(forecastObject.getString("low"));
                            forecast.setForecastWeatherDescription(forecastObject.getString("text"));
                            forecast.setCity(location.getString("city"));
                            forecast.setCurrentTemperature(conditionObject.getString("temp"));
                            forecast.setRegion(location.getString("region"));
                            forecast.setDate(conditionObject.getString("date"));

                            forecast.setDescriptionHtml(itemObject.getString("description"));

                            forecastArrayList.add(forecast);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                } if(null != callback) callback.processFinished(forecastArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getmInstance().addToRequestQueue(jsonObjectRequest);

    }
}
