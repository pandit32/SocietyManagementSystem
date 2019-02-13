package com.logicalwings.wingssociety.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.logicalwings.wingssociety.R;

import java.util.Objects;

public class ForgotPasswordActivity extends BaseActivity {

    private TextView tvSendOtp;
    private Button btnVerify;
    private EditText etOtp;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initData();

        initUi();
    }

    @Override
    protected void initData() {
        super.initData();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    protected void initUi() {
        super.initUi();
        tvSendOtp = findViewById(R.id.tv_send_otp);
        btnVerify = findViewById(R.id.btn_verify);
        etOtp = findViewById(R.id.et_otp);
        ivLogo = findViewById(R.id.iv_logo);

        zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        ivLogo.setAnimation(zoom);

        tvSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnVerify.setVisibility(View.VISIBLE);
                etOtp.setVisibility(View.VISIBLE);
            }
        });
    }
}
