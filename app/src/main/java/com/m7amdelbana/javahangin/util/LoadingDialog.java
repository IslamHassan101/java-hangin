package com.m7amdelbana.javahangin.util;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.m7amdelbana.javahangin.R;

public class LoadingDialog {

    Dialog dialog;

    public LoadingDialog(Context context) {
        dialog = new Dialog(context);
    }

    public void show() {
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_loading);
        dialog.setCancelable(false);
        dialog.show();
    }

    public void hide() {
        dialog.dismiss();
    }
}
