package com.tarex.valdo.tarex.api;

import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.model.user.UserResponse;


import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("login")
    Observable<UserResponse> user(@Body LoginForm loginForm);

}
