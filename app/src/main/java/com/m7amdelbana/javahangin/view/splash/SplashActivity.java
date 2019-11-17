package com.m7amdelbana.javahangin.view.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.util.PrefManager;
import com.m7amdelbana.javahangin.util.Utilities;
import com.m7amdelbana.javahangin.view.auth.login.LoginActivity;
import com.m7amdelbana.javahangin.view.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        PrefManager.isUserLogin(this, true);

        if (!Utilities.shared().isOnline(this)) {
            Toast.makeText(this, "No internet connection!",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        new Handler().postDelayed(() -> {
            if (PrefManager.getUser(SplashActivity.this)) {
                goToMain();
            } else {
                goToLogin();
            }
        }, SPLASH_TIME_OUT);
    }

    private void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
