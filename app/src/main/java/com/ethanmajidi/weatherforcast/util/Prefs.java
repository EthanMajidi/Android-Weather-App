package com.ethanmajidi.weatherforcast.util;

import android.app.Activity;
import android.content.SharedPreferences;

public class Prefs {
    SharedPreferences preferences;

    public Prefs(Activity activity) {
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public void setLocation(String location){
        preferences.edit().putString("location",location).apply();

    }

    public String getLocation(){
        return preferences.getString("location","Toronto,Ontario");

    }


}
