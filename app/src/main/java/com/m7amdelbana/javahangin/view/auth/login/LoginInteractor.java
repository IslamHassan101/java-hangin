package com.m7amdelbana.javahangin.view.auth.login;

import com.m7amdelbana.javahangin.network.api.APIClient;
import com.m7amdelbana.javahangin.network.models.SignForm;
import com.m7amdelbana.javahangin.network.service.APIInterface;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {

    interface OnLoginFinishedListner {

        void onSuccess();

        void onError();
    }

    void login(String email, String password,
               OnLoginFinishedListner onLoginFinishedListner) {

        SignForm signForm = new SignForm(email, password);

        APIInterface apiInterface =
                APIClient.getClient().create(APIInterface.class);

        apiInterface.login(signForm).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call,
                                   @NotNull Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    onLoginFinishedListner.onSuccess();
                }
            }

            @Override
            public void onFailure(@NotNull Call<ResponseBody> call,
                                  @NotNull Throwable t) {
                onLoginFinishedListner.onError();
            }
        });

    }
}
