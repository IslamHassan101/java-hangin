package com.m7amdelbana.javahangin.network.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SignForm implements Serializable {

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    public SignForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
