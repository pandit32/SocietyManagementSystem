package com.logicalwings.wingssociety.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.logicalwings.wingssociety.R;
import com.logicalwings.wingssociety.model.BaseModel;
import com.logicalwings.wingssociety.model.ForgetPassword;
import com.logicalwings.wingssociety.model.ForgetPasswordResponseData;

import java.util.Objects;

import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ForgetPasswordActivity extends BaseActivity {
    private TextView tvSendOtp;
    private TextView txtVerify;
    private EditText etEmail, etOtp;
    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
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
        txtVerify = findViewById(R.id.txt_verify);
        etEmail = findViewById(R.id.et_email);
        etOtp = findViewById(R.id.et_otp);
        ivLogo = findViewById(R.id.iv_logo);

        zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        ivLogo.setAnimation(zoom);

        tvSendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etEmail.getText().toString().equals(""))
                {
                    showProgressDialog("Please wait!", "Processing");
                    requestOtp();
                }
                else
                {
                    Toast.makeText(ForgetPasswordActivity.this, "Please enter email or mobile!", Toast.LENGTH_LONG).show();
                }

            }
        });

        txtVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etEmail.getText().toString().equals(""))
                {
                    if (!etOtp.getText().toString().equals(""))
                    {
                        showProgressDialog("Please wait!", "Processing");
                        verifyOtp();
                    }
                    else
                    {
                        Toast.makeText(ForgetPasswordActivity.this, "Please enter otp!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(ForgetPasswordActivity.this, "Please enter email or mobile!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void requestOtp()
    {
        service.sendOtp(etEmail.getText().toString())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseModel>() {
                    @Override
                    public void onCompleted() {
                        cancelProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        cancelProgressDialog();
                        Log.e("sendOtpResponse", e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModelResponse) {
                        cancelProgressDialog();
                        if (baseModelResponse.getStatuscode() == 1)
                        {
                            txtVerify.setVisibility(View.VISIBLE);
                            etOtp.setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            if (baseModelResponse.getMessage() != null)
                            {
                                Toast.makeText(ForgetPasswordActivity.this, baseModelResponse.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                        Log.e("sendOtpResponse", baseModelResponse.getMessage());
                    }
                });
    }

    private void verifyOtp()
    {
        Log.e("data", etEmail.getText().toString()+"/"+etOtp.getText().toString());
        service.verifyUser(etEmail.getText().toString(), etOtp.getText().toString())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ForgetPasswordResponseData>() {
                    @Override
                    public void onCompleted() {
                        cancelProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("verifyOtpError", e.getMessage());
                        cancelProgressDialog();
                    }

                    @Override
                    public void onNext(ForgetPasswordResponseData forgetPasswordResponseData) {
                        cancelProgressDialog();
                        Log.e("verifyOtpResponse", new Gson().toJson(forgetPasswordResponseData));
                        if (forgetPasswordResponseData.getStatuscode() == 1)
                        {
                            if (forgetPasswordResponseData.getData().getId()>0)
                            {
                                Toast.makeText(ForgetPasswordActivity.this, forgetPasswordResponseData.getMessage(), Toast.LENGTH_LONG).show();
                                Intent i = new Intent(ForgetPasswordActivity.this, ResetPasswordActivity.class);
                                i.putExtra("userId", String.valueOf(forgetPasswordResponseData.getData().getId()));
                                startActivity(i);
                            }
                        }
                    }
                });
    }
}
