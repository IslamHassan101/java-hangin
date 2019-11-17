package com.m7amdelbana.javahangin.view.main.navigation.home;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m7amdelbana.javahangin.R;
import com.m7amdelbana.javahangin.network.api.APIClient;
import com.m7amdelbana.javahangin.network.models.Place;
import com.m7amdelbana.javahangin.network.service.APIInterface;
import com.m7amdelbana.javahangin.util.ItemAdapterClick;
import com.m7amdelbana.javahangin.util.LoadingDialog;
import com.m7amdelbana.javahangin.view.place.PlaceActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        LoadingDialog loadingDialog = new LoadingDialog(getActivity());
        loadingDialog.show();

        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        apiInterface.getPlaces().enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(@NotNull Call<List<Place>> call,
                                   @NotNull Response<List<Place>> response) {
                if (response.isSuccessful()) {
                    places = response.body();

                    PlaceAdapter placeAdapter =
                            new PlaceAdapter(places,
                                    getActivity().getApplicationContext(),
                                    HomeFragment.this);

                    GridLayoutManager gridLayoutManager = new
                            GridLayoutManager(getActivity().getApplicationContext(),
                            2, GridLayoutManager.VERTICAL, false);

                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(placeAdapter);
                }
            }

            @Override
            public void onFailure(@NotNull Call<List<Place>> call,
                                  @NotNull Throwable t) {
                loadingDialog.hide();
                Log.v("onFailureResult",
                        Objects.requireNonNull(t.getMessage()));
            }
        });

        return view;
    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getActivity(), PlaceActivity.class);
        intent.putExtra("PLACE", places.get(position));
        getActivity().startActivity(intent);
    }
}
