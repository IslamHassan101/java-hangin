package com.m7amdelbana.javahangin.view.auth.login;

import android.util.Patterns;

public class LoginPresenter
        implements LoginInteractor.OnLoginFinishedListner {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    LoginPresenter(LoginView loginView,
                   LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    void checkEmailAndPassword(String email, String password) {
        if (email.isEmpty()) {
            loginView.emailError("Empty Email");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginView.emailError("Invalid Email");
        } else if (password.isEmpty()) {
            loginView.passwordError();
        } else {
            loginView.showDialog();
            loginInteractor.login(email, password, this);
        }
    }

    @Override
    public void onSuccess() {
        loginView.hideDialog();
        loginView.validCradintial();
    }

    @Override
    public void onError() {
        loginView.hideDialog();
        loginView.inValidCradintial();
    }
}
