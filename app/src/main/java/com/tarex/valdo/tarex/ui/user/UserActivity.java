package com.tarex.valdo.tarex.ui.user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.PresenterType;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.forms.LoginForm;
import com.tarex.valdo.tarex.model.user.User;
import com.tarex.valdo.tarex.model.user.tokenDto.TokenDto;
import com.tarex.valdo.tarex.ui.base.BaseActivity;

import io.reactivex.Single;

public class UserActivity extends BaseActivity implements UserView {

    EditText login;
    EditText password;

    Button go;

    @InjectPresenter
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        go = findViewById(R.id.btn_go);

        go.setOnClickListener(view ->
                presenter.user(login.getText().toString(),password.getText().toString()));
    }

    @Override
    public void handleError(Throwable error) {

    }
    
    @Override
    public void setAccessToken(String accessToken) {
        Log.d("LOG!",accessToken);
    }




}
