package com.logicalwings.wingssociety.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;

import com.logicalwings.wingssociety.api.APIClient;
import com.logicalwings.wingssociety.api.APIInterface;
import com.logicalwings.wingssociety.utils.LibFile;

public class BaseActivity extends AppCompatActivity {

    protected Animation animFadeIn, animZoomIn, animZoomOut, zoom;
    private ProgressDialog progressDialog;
    protected LibFile libFile;
    protected APIInterface service;

    protected void initData()
    {
        service = APIClient.getClient(BaseActivity.this);
        libFile = LibFile.getInstance(this);
    }

    protected void initUi()
    {

    }

    protected void updateUi()
    {

    }

    protected void startIntentWithoutBack(Class<?> activityClass)
    {
        Intent i = new Intent(getApplicationContext(), activityClass);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }

    protected void startIntentWithBack(Class<?> activityClass)
    {
        Intent i = new Intent(getApplicationContext(), activityClass);
        startActivity(i);
    }

    protected void showProgressDialog(String title, String message) {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        progressDialog = new ProgressDialog(this);

        if (title != null)
            progressDialog.setTitle(title);

        progressDialog.setMessage(message);

        progressDialog.setCancelable(false);

        progressDialog.show();

    }

    protected void cancelProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
