package com.logicalwings.wingssociety.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import com.logicalwings.wingssociety.R;
import com.logicalwings.wingssociety.utils.AppConstants;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();

        initUi();
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initUi() {
        super.initUi();
        goToNextScreen();
    }

    private void goToNextScreen()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startIntentWithoutBack(LoginActivity.class);
            }
        }, AppConstants.SPLASH_TIME_MILLISECOND);
    }
}
