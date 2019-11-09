package com.m7amdelbana.javahangin.view.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.util.LoadingDialog;
import com.m7amdelbana.javahangin.view.main.navigation.BookingFragment;
import com.m7amdelbana.javahangin.view.main.navigation.home.HomeFragment;
import com.m7amdelbana.javahangin.view.main.navigation.MapFragment;
import com.m7amdelbana.javahangin.view.main.navigation.MoreFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;
    private Toolbar toolbar;
    private TextView tvToolbar;
    private ImageView imgToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        initToolbar();

        openFragment(new HomeFragment());
        tvToolbar.setText(R.string.home);

        imgToolbar.setVisibility(View.GONE);

        LoadingDialog loadingDialog = new LoadingDialog(this);
        loadingDialog.show();

        new Handler().postDelayed(() -> loadingDialog.hide(), 5000);
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.main_toolbar);
        tvToolbar = findViewById(R.id.toolbar_title_textView);
        imgToolbar = findViewById(R.id.toolbar_back_imageView);
        setSupportActionBar(toolbar);

        imgToolbar.setVisibility(View.GONE);
    }

    private void checkPermission() {
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    private void initUI() {
        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length <= 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission denied!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                openFragment(new HomeFragment());
                tvToolbar.setText(R.string.home);
                return true;
            case R.id.nav_booking:
                openFragment(new BookingFragment());
                tvToolbar.setText(R.string.booking);
                return true;
            case R.id.nav_map:
                openFragment(new MapFragment());
                tvToolbar.setText(R.string.nearby_places);
                return true;
            case R.id.nav_more:
                openFragment(new MoreFragment());
                tvToolbar.setText(R.string.more);
                return true;
        }
        return false;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frameLayout, fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        showDialog();
    }

    public void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage("Are you sure to exist the app?");

        builder.setPositiveButton("Yes",
                (dialogInterface, i) -> super.onBackPressed());

        builder.setNegativeButton("No",
                (dialogInterface, i) -> {

                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
