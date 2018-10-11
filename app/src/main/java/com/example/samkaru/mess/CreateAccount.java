package com.example.samkaru.mess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateAccount extends AppCompatActivity {
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        preferences = getSharedPreferences("general",MODE_PRIVATE);
    }

    public void skip(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("Skip",true);
        editor.apply();

        startActivity(new Intent(this,MainActivity.class));
        finish();

    }
}
