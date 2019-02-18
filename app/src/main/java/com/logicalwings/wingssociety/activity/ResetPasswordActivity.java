package com.logicalwings.wingssociety.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.logicalwings.wingssociety.R;
import com.logicalwings.wingssociety.model.BaseModel;
import com.logicalwings.wingssociety.model.ForgetPasswordResponseData;
import com.logicalwings.wingssociety.utils.AppConstants;

import java.util.Objects;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ResetPasswordActivity extends BaseActivity {

    private EditText etNewPass, etConfirmPass;
    private Button btnSubmit;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
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

        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            userId = bundle.getString("userId");
            Log.e("userId", userId);
        }
    }

    @Override
    protected void initUi() {
        super.initUi();
        etNewPass = findViewById(R.id.et_new_pass);
        etConfirmPass = findViewById(R.id.et_confirm_pass);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etNewPass.getText().toString().equals("") && !etConfirmPass.getText().toString().equals(""))
                {
                    if (etNewPass.getText().toString().equals(etConfirmPass.getText().toString()))
                    {
                        if (userId != null)
                        {
                            showProgressDialog("Please wait!", "Loading");
                            changePassword();
                        }
                    }
                    else
                    {
                        Toast.makeText(ResetPasswordActivity.this, "Password and confirm password should be same!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(ResetPasswordActivity.this, "Please enter new password!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void changePassword()
    {
        service.resetPassword(userId, etConfirmPass.getText().toString())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseModel>() {
                    @Override
                    public void onCompleted() {
                        cancelProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("resetPassError", e.getMessage());
                        cancelProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        cancelProgressDialog();
                        Log.e("resetPassResponse", new Gson().toJson(baseModel));
                        if (baseModel.getStatuscode() == 1)
                        {
                            libFile.setString(AppConstants.USER_ID, userId);
                            libFile.setBoolean(AppConstants.IS_LOGIN, true);
                            Toast.makeText(ResetPasswordActivity.this, baseModel.getMessage(), Toast.LENGTH_LONG).show();
                            startIntentWithoutBack(DashboardActivity.class);
                        }
                    }
                });
    }

}
