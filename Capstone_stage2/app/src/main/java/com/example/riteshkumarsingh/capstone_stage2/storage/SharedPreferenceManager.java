package com.example.riteshkumarsingh.capstone_stage2.storage;

import android.content.SharedPreferences;

public class SharedPreferenceManager {

    private static final String SORT_BY_KEY = "SORT_BY_KEY";

    private SharedPreferences mSharedPreferences;

    public SharedPreferenceManager(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    private void putString(String key, String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private String getString(String key, String defValue) {
        SharedPreferences sharedPreferences = mSharedPreferences;
        return sharedPreferences.getString(key, defValue);
    }

    private void putInt(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    public void putSortByValue(int value) {
        putInt(SORT_BY_KEY, value);
    }

    public int getSortByValue() {
        return getInt(SORT_BY_KEY, 0);
    }
}