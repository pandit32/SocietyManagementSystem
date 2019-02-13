package com.logicalwings.wingssociety.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.logicalwings.wingssociety.R;

public class LoginActivity extends BaseActivity {

    private TextView tvForgetPassword;
    private EditText etEmail, etPass;
    private ImageView ivLogo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
        tvForgetPassword = findViewById(R.id.tv_forget_password);
        etEmail = findViewById(R.id.et_email);
        etPass = findViewById(R.id.et_pass);
        ivLogo = findViewById(R.id.iv_logo);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);

        animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out);

        zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        ivLogo.setAnimation(zoom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                etPass.setVisibility(View.VISIBLE);
                etPass.setAnimation(animFadeIn);

            }
        }, 2000);

        etEmail.setVisibility(View.VISIBLE);
        etEmail.setAnimation(animFadeIn);

        tvForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startIntentWithBack(ForgotPasswordActivity.class);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        ivLogo.setAnimation(zoom);
    }
}
