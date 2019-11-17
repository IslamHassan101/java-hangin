package com.m7amdelbana.javahangin.network.service;

import com.m7amdelbana.javahangin.network.api.APIConstant;
import com.m7amdelbana.javahangin.network.models.Place;
import com.m7amdelbana.javahangin.network.models.SignForm;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @GET(APIConstant.SERVICE_PLACES)
    Call<List<Place>> getPlaces();

    @GET(APIConstant.SERVICE_PLACES + "/{id}")
    Call<Place> getPlace(@Path("id") String id,
                         @Query("pageNumber") int pageNumber,
                         @Query("pageSize") int pageSize);

    @POST(APIConstant.SERVICE_USER_LOGIN)
    Call<ResponseBody> login(@Body SignForm signForm);
}
