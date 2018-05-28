package com.tarex.valdo.tarex.utils.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_SURNAME = "PREF_KEY_CURRENT_USER_SURNAME";
    private static final String PREF_KEY_CURRENT_USER_PHONE = "PREF_KEY_CURRENT_USER_PHONE";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;

    public AppPreferencesHelper( Context context,
                               String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }


    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentPhoneNumber() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PHONE,null);
    }

    @Override
    public void setCurrentPhoneNumber(String phoneNumber) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PHONE, phoneNumber).apply();
    }

    @Override
    public String getCurrentUserSurname() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_SURNAME,null);
    }

    @Override
    public void setCurrentUserSurname(String userSurname) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_SURNAME, userSurname).apply();

    }

    public SharedPreferences getmPrefs() {
        return mPrefs;
    }


}
