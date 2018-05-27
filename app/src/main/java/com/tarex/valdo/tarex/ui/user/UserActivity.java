package com.tarex.valdo.tarex.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.ui.base.BaseActivity;
import com.tarex.valdo.tarex.ui.registration.RegistrationActivity;
import com.tarex.valdo.tarex.ui.restaurantList.RestaurantListActivity;

public class UserActivity extends BaseActivity implements UserView {

    private EditText etLogin;
    private EditText etPassword;

    private TextView tvLoginWithoutAuth;
    private TextView tvRegistration;

    private Button btnLogin;

    private String shName = "shPref";

    @InjectPresenter
    UserPresenter presenter;

    @Override
    protected void onStart() {
        super.onStart();
        if (presenter.getAccesToken(this,shName) != null);
        restarauntIntent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        initView();

        btnLogin.setOnClickListener(view -> {
            if (etLogin.getText() != null && etPassword != null) {
                presenter.user(etLogin.getText().toString(), etPassword.getText().toString());
                restarauntIntent();
            }

        });

        tvLoginWithoutAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restarauntIntent();
            }
        });

        tvRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, RegistrationActivity.class);
                startActivity(intent);
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

    private void restarauntIntent (){
        Intent intent = new Intent(UserActivity.this, RestaurantListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }



}
