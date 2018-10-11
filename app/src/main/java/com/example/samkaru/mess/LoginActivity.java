package com.example.samkaru.mess;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {
   TextInputLayout userName,password;
   SharedPreferences preferences = getSharedPreferences("general",MODE_PRIVATE);
    String userNameSaved;
    String userPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        userName = findViewById(R.id.login_username);

        password = findViewById(R.id.login_password);

        userNameSaved = preferences.getString("userName",null);
        userPassword= preferences.getString("Password",null);



    }

    public void logIn(View view){
        if(password.getEditText().getText().toString().equals(userName) && userName.getEditText().getText().toString().equals(userPassword)){

        }else{


        }




    }
}
