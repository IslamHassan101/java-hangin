package com.m7amdelbana.javahangin.view.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.util.LoadingDialog;
import com.m7amdelbana.javahangin.util.PrefManager;
import com.m7amdelbana.javahangin.view.auth.RegisterActivity;
import com.m7amdelbana.javahangin.view.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvSignUp;

    private LoginPresenter loginPresenter = new LoginPresenter(this,
            new LoginInteractor());

    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Log.v("CHECK_DIALIG", "setContentView");

        edtEmail = findViewById(R.id.login_email_editText);
        edtPassword = findViewById(R.id.login_password_editText);
        btnLogin = findViewById(R.id.login_button);
        tvSignUp = findViewById(R.id.signUp_textView);

        loadingDialog = new LoadingDialog(this);

        btnLogin.setOnClickListener(view -> {
            String email = edtEmail.getText().toString().trim();
            String password = edtPassword.getText().toString().trim();
            loginPresenter.checkEmailAndPassword(email, password);
        });

        tvSignUp.setOnClickListener(view -> goToRegister());

    }

    private void goToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void showDialog() {
        loadingDialog.show();
    }

    @Override
    public void hideDialog() {
        loadingDialog.hide();
    }

    @Override
    public void emailError(String error) {
        edtEmail.setError(error);
    }

    @Override
    public void passwordError() {
        edtPassword.setError("Invalid Password");
    }

    @Override
    public void validCradintial() {
        Toast.makeText(this, "Welcome back!", Toast.LENGTH_SHORT).show();
        goToMain();
    }

    @Override
    public void inValidCradintial() {
        Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();

    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
