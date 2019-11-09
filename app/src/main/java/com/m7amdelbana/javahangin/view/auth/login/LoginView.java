package com.m7amdelbana.javahangin.view.auth.login;

public interface LoginView {

    void showDialog();

    void hideDialog();

    void emailError(String error);

    void passwordError();

    void validCradintial();

    void inValidCradintial();
}
