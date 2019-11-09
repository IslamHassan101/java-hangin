package com.m7amdelbana.javahangin.view.auth.login;

import android.os.Handler;

public class LoginInteractor {

    interface OnLoginFinishedListner {

        void onSuccess();

        void onError();
    }

    void login(String email, String password,
               OnLoginFinishedListner onLoginFinishedListner) {
        String defaultEmail = "user@gmail.com";
        String defaultPassword = "123456";

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (email.equalsIgnoreCase(defaultEmail)
                        && password.equals(defaultPassword)) {
                    onLoginFinishedListner.onSuccess();
                } else {
                    onLoginFinishedListner.onError();
                }
            }
        }, 3000);
    }
}
