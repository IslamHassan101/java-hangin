package com.m7amdelbana.javahangin.view.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.m7amdelbana.javahangin.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.login_email_editText);
        edtPassword = findViewById(R.id.login_password_editText);
        btnLogin = findViewById(R.id.login_button);
        tvSignUp = findViewById(R.id.signUp_textView);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (valid(email, password)) {
                    Toast.makeText(LoginActivity.this, "Valid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
            }
        });
    }

    private void goToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private boolean valid(String email, String password) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.isEmpty()) {
            edtEmail.setError("Enter email");
            return false;
        } else if (password.isEmpty()) {
            edtPassword.setError("Enter password");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.setError("Invalid email");
            return false;
        } else if (!email.matches(emailPattern)) {
            edtEmail.setError("Invalid email");
            return false;
        } else if (password.length() < 6) {
            edtPassword.setError("Invalid password");
            return false;
        }

        return true;
    }
}
