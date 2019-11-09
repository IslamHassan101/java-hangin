package com.m7amdelbana.javahangin.view.main.navigation.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.models.Place;
import com.m7amdelbana.javahangin.util.ItemAdapterClick;
import com.m7amdelbana.javahangin.view.place.PlaceActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ItemAdapterClick {

    private RecyclerView recyclerView;
    private List<Place> places;


    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.home_recyclerView);

        places = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            places.add(new Place("Place " + (i + 1), "https://picsum.photos/id/867/200/200", "Address " + (i + 1)));
        }

        PlaceAdapter placeAdapter =
                new PlaceAdapter(places,
                        getActivity().getApplicationContext(),
                        this);

        GridLayoutManager gridLayoutManager = new
                GridLayoutManager(getActivity().getApplicationContext(),
                2, GridLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(placeAdapter);

        return view;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), PlaceActivity.class);
        intent.putExtra("PLACE", places.get(position));
        getActivity().startActivity(intent);
    }
}
