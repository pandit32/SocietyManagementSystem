package com.logicalwings.wingssociety.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.logicalwings.wingssociety.R;
import com.logicalwings.wingssociety.model.BaseModel;
import com.logicalwings.wingssociety.model.DashboardResponse;
import com.logicalwings.wingssociety.utils.AppConstants;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DashboardActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initData();

        initUi();
    }

    @Override
    protected void initData() {
        super.initData();
        userId = libFile.getString(AppConstants.USER_ID);

        Log.e("getUserId", userId);
    }

    @Override
    protected void initUi() {
        super.initUi();

        if (userId != null)
        {
            showProgressDialog("Please wait!", "Loading Dashboard");
            getDashboardData();
        }
    }

    private void getDashboardData()
    {
        /*service.getDashboardResponse(userId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DashboardResponse>() {
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
                    public void onNext(DashboardResponse dashboardResponse) {
                        cancelProgressDialog();
                        Log.e("dashboardResponse", new Gson().toJson(dashboardResponse));
                    }
                });*/
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {
            confirmLogoutDialog();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void confirmLogoutDialog()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(
                DashboardActivity.this).create();
        alertDialog.setIcon(R.drawable.ic_logout);

        alertDialog.setTitle("Logout !");

        alertDialog.setMessage("Are you sure?");

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                libFile.setBoolean(AppConstants.IS_LOGIN, false);
                startIntentWithoutBack(LoginActivity.class);
                dialogInterface.dismiss();
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alertDialog.show();
    }
}
