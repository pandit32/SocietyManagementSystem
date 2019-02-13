package com.logicalwings.wingssociety.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;

public class BaseActivity extends AppCompatActivity {
    protected Animation animFadeIn, animZoomIn, animZoomOut, zoom;
    protected void initData()
    {

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
}
