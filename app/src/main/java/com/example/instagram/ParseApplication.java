package com.example.instagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        // Register parse models
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("n6LMhbehP5JevoMSeAYifUVcM2fCJqJnrdunv6F5")
                .clientKey("WdNUYc74eSQ1E19xcK9XowQEoS14koR4LTkH5Awz")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
