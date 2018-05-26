package com.tarex.valdo.tarex.ui.user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.ui.base.BaseActivity;

public class UserActivity extends BaseActivity implements UserView {

    EditText etLogin;
    EditText etPassword;

    TextView tvLoginWithoutAuth;
    TextView tvRegistration;

    Button btnLogin;

    @InjectPresenter
    UserPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        initView();

        btnLogin.setOnClickListener(view -> {
            if (etLogin.getText() != null && etPassword != null)
                presenter.user(etLogin.getText().toString(), etPassword.getText().toString());

        });

        tvLoginWithoutAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 5/27/2018 кидаем на активити со списком ресторанов
            }
        });

        tvRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 5/27/2018 кидаем на регистрацию
            }
        });

    }

    @Override
    public void handleError(Throwable error) {

    }

    @Override
    public void setAccessToken(String accessToken) {
        presenter.createSharedPreferences(this,accessToken);
    }

    @Override
    public void getSpToken(String token) {
        if (token != null) {
            Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        }
    }

    private void initView (){
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvLoginWithoutAuth = findViewById(R.id.tv_login_without_auth);
        tvRegistration = findViewById(R.id.tv_registration);
    }



}
