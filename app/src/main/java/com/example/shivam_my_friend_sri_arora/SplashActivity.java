package com.example.shivam_my_friend_sri_arora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load the password
        SharedPreferences settings = getSharedPreferences("PREFS",0);
        password = settings.getString("password","");

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent;
            if(password.equals("")) {
                //if there is no password
                intent = new Intent(getApplicationContext(), CreatePasswardActivity.class);
            } else {
                //if there is a password
                intent = new Intent(getApplicationContext(), EnterPasswordActivity.class);
            }
            startActivity(intent);
            finish();

        }, 2000);
    }
}