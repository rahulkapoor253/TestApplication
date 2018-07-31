package com.example.rahulkapoor.testapplication.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static Context context;
    private static SharedPref sharedPref = new SharedPref();

    public static SharedPref getInstance(final Context mContext) {
        context = mContext;
        return sharedPref;
    }

    public void save_token(final String token, final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("token", token);
        editor.apply();
    }

    public String read_token(final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        return sharedpref.getString("token", "");
    }

    public void save_email(final String email, final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("email", email);
        editor.apply();
    }

    public String read_email(final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        return sharedpref.getString("email", "");
    }

    public void save_picture(final String picture, final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("picture", picture);
        editor.apply();
    }

    public String read_picture(final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        return sharedpref.getString("picture", "");
    }

    public void save_username(final String name, final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("name", name);
        editor.apply();
    }

    public String read_username(final Context context) {
        SharedPreferences sharedpref = context.getSharedPreferences("sample", Context.MODE_PRIVATE);
        return sharedpref.getString("name", "");
    }


}
