package com.logicalwings.wingssociety.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class LibFile {
    public static final String KEY_TOKEN = "user_token";
    private Context context;
    private static LibFile instance;
    private SharedPreferences settings;

    public LibFile(Context context) {
        this.context = context;
        settings = context.getSharedPreferences(AppConstants.PREFS_FILE_NAME_PARAM, 0);

    }
    public static LibFile getInstance(Context context) {
        if (instance == null) {
            instance = new LibFile(context);
        }
        return instance;
    }

    public void setString(String key, String value) {
        settings.edit().putString(key, value).apply();
    }

    public String getString(String key) {
        return settings.getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        return settings.getString(key, defaultValue);
    }

    public void setInt(String key, int value) {
        settings.edit().putInt(key, value).apply();
    }

    public int getInt(String key) {
        return settings.getInt(key, 0);
    }

    public int getInt(String key, int defaultValue) {
        return settings.getInt(key, defaultValue);
    }

    public void setBoolean(String key, boolean value) {
        settings.edit().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return settings.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return settings.getBoolean(key, defaultValue);
    }
}
