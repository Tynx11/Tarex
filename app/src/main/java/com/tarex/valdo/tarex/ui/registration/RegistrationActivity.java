package com.tarex.valdo.tarex.ui.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tarex.valdo.tarex.R;
import com.tarex.valdo.tarex.ui.base.BaseActivity;

public class RegistrationActivity extends BaseActivity implements RegistrationView {

    private EditText etLogin;
    private EditText etPassword;
    private EditText etName;
    private EditText etSurname;
    private EditText etPhone;

    private Button btnRegistration;

    @InjectPresenter
    RegistrationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getLogin() != null && getPassword() != null && getName() != null
                        && getSurname() != null && getPhoneNumber() != null){
                    presenter.registraion(getLogin(),getPassword(),getName(),getSurname(),getPhoneNumber());
            }
                }
        });

    }

    @Override
    public void handleError(Throwable error) {

    }

    @Override
    public void setAccessToken(String tokenDto) {
        presenter.createSharedPreferences(this,tokenDto);
    }

    @Override
    public void getSpToken(String token) {
        if (token != null) {
            Toast.makeText(this, token, Toast.LENGTH_SHORT).show();
        }
    }

    private void init () {
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);
        etName = findViewById(R.id.et_name);
        etSurname = findViewById(R.id.et_surname);
        etPhone = findViewById(R.id.et_phone);
        btnRegistration = findViewById(R.id.btn_register);
    }

    private String getLogin () {
        return etLogin.getText().toString();
    }

    private String getPassword () {
        return etPassword.getText().toString();
    }

    private String getName() {
        return etName.getText().toString();
    }

    private String getSurname () {
        return etSurname.getText().toString();
    }

    private String getPhoneNumber () {
        return etPhone.getText().toString();
    }
}