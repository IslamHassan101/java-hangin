package com.m7amdelbana.javahangin.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefManager {

    private static final String USER_EXIST = "userExist";

    public static void isUserLogin(Context context, boolean isUserLogin) {
        SharedPreferences.Editor editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean(USER_EXIST, isUserLogin);
        editor.apply();
    }

    public static boolean getUser(Context context) {
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(USER_EXIST, false);
    }
}
