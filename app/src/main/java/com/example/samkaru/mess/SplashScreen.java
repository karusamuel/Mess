package com.example.samkaru.mess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class SplashScreen extends AppCompatActivity {

    SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        preference = getSharedPreferences("general",MODE_PRIVATE);

        if(!preference.getBoolean("PasswordSet",false)){
            if(!preference.getBoolean("Skip",false)){

                startActivity(new Intent(this,CreateAccount.class));

            }else{
                startActivity(new Intent(this,MainActivity.class));


            }


        }else{
            startActivity(new Intent(this,LoginActivity.class));
        }

        finish();


    }



}
