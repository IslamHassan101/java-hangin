package com.m7amdelbana.javahangin.view.main.navigation.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.network.models.Place;
import com.squareup.picasso.Picasso;

public class PlaceHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvAddress;
    private ImageView img;

    public PlaceHolder(@NonNull View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.place_name_textView);
        tvAddress = itemView.findViewById(R.id.place_address_textView);
        img = itemView.findViewById(R.id.place_imageView);
    }

    void bind(Place place, Context context) {
        tvName.setText(place.getName());
        tvAddress.setText(place.getAddress());
        Picasso.with(context)
                .load(place.getImage())
                .placeholder(R.drawable.img_placeholder)
                .into(img);
    }
}
