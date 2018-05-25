package com.tarex.valdo.tarex.api;

import android.support.annotation.NonNull;

import com.tarex.valdo.tarex.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class LoggingInterceptor implements Interceptor {

    private final Interceptor loggingInterceptor;

    private LoggingInterceptor() {
        loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    @NonNull
    public static Interceptor create() {
        return new LoggingInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return loggingInterceptor.intercept(chain);
    }
}
