package com.m7amdelbana.javahangin.view.main.navigation.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.network.models.Place;
import com.m7amdelbana.javahangin.util.ItemAdapterClick;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceHolder> {

    private List<Place> places;
    private Context context;
    private ItemAdapterClick itemAdapterClick;

    public PlaceAdapter(List<Place> places, Context context, ItemAdapterClick itemAdapterClick) {
        this.places = places;
        this.context = context;
        this.itemAdapterClick = itemAdapterClick;
    }

    @NonNull
    @Override
    public PlaceHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new PlaceHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceHolder holder, final int position) {
        holder.bind(places.get(position), context);

        holder.itemView.setOnClickListener(view -> itemAdapterClick.onClick(position));
    }

    @Override
    public int getItemCount() {
        return places.size();
    }
}
