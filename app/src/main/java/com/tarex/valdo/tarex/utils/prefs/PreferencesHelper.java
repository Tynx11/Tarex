package com.tarex.valdo.tarex.utils.prefs;

import com.arellomobile.mvp.MvpView;

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentPhoneNumber();

    void setCurrentPhoneNumber(String phoneNumber);

    String getCurrentUserSurname();

    void   setCurrentUserSurname(String userSurname);


}
