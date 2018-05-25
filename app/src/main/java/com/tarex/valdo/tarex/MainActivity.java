package com.tarex.valdo.tarex;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tarex.valdo.tarex.api.ApiFactory;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ApiFactory.recreate();
    }





}
