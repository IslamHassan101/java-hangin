package com.m7amdelbana.javahangin.view;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.m7amdelbana.javahangin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    // @BindView(R.id.login_email_editText)
    EditText edtEmail;
    // @BindView(R.id.login_password_editText)
    EditText edtPassword;
    // @BindView(R.id.login_button)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ButterKnife.bind(this);

        edtEmail = findViewById(R.id.login_email_editText);
        edtPassword = findViewById(R.id.login_password_editText);
        btnLogin = findViewById(R.id.login_button);

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
    }

//    @OnClick(R.id.login_button)
//    public void onViewClicked() {
//        String email = edtEmail.getText().toString().trim();
//        String password = edtPassword.getText().toString().trim();
//        if (valid(email, password)) {
//            Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
//        }
//    }

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
