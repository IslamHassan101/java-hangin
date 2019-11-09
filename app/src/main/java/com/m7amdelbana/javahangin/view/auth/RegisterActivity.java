package com.m7amdelbana.javahangin.view.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.m7amdelbana.javahangin.R;

public class RegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvToolbar;
    private ImageView imgToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initToolbar();

        tvToolbar.setText(R.string.create_account);
        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.main_toolbar);
        tvToolbar = findViewById(R.id.toolbar_title_textView);
        imgToolbar = findViewById(R.id.toolbar_back_imageView);
        setSupportActionBar(toolbar);
    }
}
