package com.logicalwings.wingssociety.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.logicalwings.wingssociety.R;
import com.logicalwings.wingssociety.api.APIClient;
import com.logicalwings.wingssociety.api.APIInterface;
import com.logicalwings.wingssociety.model.ErrorClass;
import com.logicalwings.wingssociety.model.LoginRequest;
import com.logicalwings.wingssociety.model.User;
import com.logicalwings.wingssociety.model.UserResponseData;
import com.logicalwings.wingssociety.utils.AppConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends BaseActivity {

    private TextView tvForgetPassword;
    private EditText etEmail, etPass;
    private ImageView ivLogo;
    private TextView txtLogin;

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
        txtLogin = findViewById(R.id.txt_login);

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
                startIntentWithBack(ForgetPasswordActivity.class);
            }
        });

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidations();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        zoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        ivLogo.setAnimation(zoom);
    }

    private void checkValidations()
    {
        if (!etEmail.getText().toString().equals(""))
        {
            if (!etPass.getText().toString().equals(""))
            {
                showProgressDialog("Please wait!", "Loading");

                makeLogin("password", etEmail.getText().toString(), etPass.getText().toString(), 1, 2, "deviceId", 2, "imei", "test");
            }
            else
            {
                Toast.makeText(LoginActivity.this, "Please enter password!", Toast.LENGTH_LONG).show();
            }

        }
        else
        {
            Toast.makeText(LoginActivity.this, "Please enter email or Mobile no.!", Toast.LENGTH_LONG).show();
        }
    }
    private void makeLogin(String grantPassword, String userName, String password, int clientId, int loginId, String mobileDeviceId, int deviceOsType, String imei, String deviceNotification)
    {
        service.userLogin(grantPassword, userName, password, clientId, loginId, mobileDeviceId, deviceOsType, imei, deviceNotification)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response<User>>() {
                    @Override
                    public void onCompleted() {
                        cancelProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", e.getMessage());
                        cancelProgressDialog();
                    }

                    @Override
                    public void onNext(Response<User> userResponseData) {
                        cancelProgressDialog();
                        Log.e("responseData", new Gson().toJson(userResponseData.body().getAccessToken()));
                        ErrorClass errorClass = null;

                        if (userResponseData.code() == 200)
                        {
                            libFile.setString(AppConstants.ACCESS_TOKEN, userResponseData.body().getAccessToken());
                            libFile.setString(AppConstants.TOKEN_TYPE, userResponseData.body().getTokenType());
                            libFile.setString(AppConstants.EXPIRES_IN, String.valueOf(userResponseData.body().getExpiresIn()));
                            libFile.setString(AppConstants.USER_ID, userResponseData.body().getUserid());
                            libFile.setString(AppConstants.USER_FULL_NAME, userResponseData.body().getUserFullName());
                            libFile.setString(AppConstants.DATE_TIME_FORMAT, userResponseData.body().getDateTimeFormat());
                            libFile.setString(AppConstants.IS_REDIRECT_TO_DASHBOARD, userResponseData.body().getIsRedirectToDashboard());
                            libFile.setString(AppConstants.WINGS_ID, userResponseData.body().getWingId());
                            libFile.setString(AppConstants.FLAT_ID, userResponseData.body().getFlatId());
                            libFile.setString(AppConstants.FLAT_NO, userResponseData.body().getFlatNo());
                            libFile.setString(AppConstants.GENDER, userResponseData.body().getGender());
                            libFile.setString(AppConstants.IS_ALLOW_LOGIN_AS_USER, userResponseData.body().getIsAllowLoginAsUser());
                            libFile.setString(AppConstants.LOGIN_TYPE, userResponseData.body().getLoginType());
                            libFile.setString(AppConstants.ISSUED, userResponseData.body().getIssued());
                            libFile.setString(AppConstants.EXPIRES, userResponseData.body().getExpires());
                            libFile.setBoolean(AppConstants.IS_LOGIN, true);

                            Toast.makeText(LoginActivity.this, "successfully logged in!", Toast.LENGTH_LONG).show();
                            startIntentWithoutBack(DashboardActivity.class);

                            Log.e("responseData", new Gson().toJson(userResponseData));
                        }
                        else
                        {
                            try {

                                if (userResponseData.errorBody() != null)
                                {
                                    Gson gson = new GsonBuilder().create();

                                    BufferedReader r = new BufferedReader(new InputStreamReader(userResponseData.errorBody().byteStream()));
                                    StringBuilder total = new StringBuilder();
                                    String line;
                                    while ((line = r.readLine()) != null) {
                                        total.append(line).append('\n');
                                    }
                                    Log.e("LoginUri : ", ""+ userResponseData.body() + " \n Code :" + userResponseData.code() + "\n errorBody:" + total.toString());
                                    errorClass = gson.fromJson(total.toString().trim(), ErrorClass.class);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (errorClass != null && errorClass.mError_description != null)
                                Log.e("errorMessage", errorClass.mError_description);
                            Toast.makeText(LoginActivity.this, errorClass.mError_description, Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
}
