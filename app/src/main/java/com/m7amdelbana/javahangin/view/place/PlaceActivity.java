package com.m7amdelbana.javahangin.view.place;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.models.Place;

public class PlaceActivity extends AppCompatActivity {

    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        place = (Place) getIntent().getSerializableExtra("PLACE");
        Toast.makeText(this, place.getName(), Toast.LENGTH_SHORT).show();
    }
}
