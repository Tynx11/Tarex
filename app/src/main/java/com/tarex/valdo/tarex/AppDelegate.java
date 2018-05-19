package com.tarex.valdo.tarex;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppDelegate extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Sanfrancisco.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
