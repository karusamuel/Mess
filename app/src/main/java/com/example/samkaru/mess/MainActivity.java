package com.example.samkaru.mess;

/*
* Main activity this is the main entry point to the application
*
*
*
*
* */

//import to the main class

import android.content.Intent;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton menu,shop,fav,notifications;
    Animation click;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.setDefaultValues(this,R.xml.preference,false);

        menu =findViewById(R.id.menu);
        shop =findViewById(R.id.shop);
        fav = findViewById(R.id.fav);
        notifications=findViewById(R.id.not);
        click = AnimationUtils.loadAnimation(this,R.anim.click_anim);
        menu.setAnimation(click);
        shop.setAnimation(click);
        notifications.setAnimation(click);
        fav.setAnimation(click);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(this,Settings.class));
                return true;
            default:
             return super.onOptionsItemSelected(item);

        }


    }
    public void menu(View view){
        menu.startAnimation(click);
        startActivity(new Intent(getApplicationContext(),MenuActivity.class));
    }
    public void shop(View view){
        shop.startAnimation(click);
        startActivity(new Intent(this,ShopActivity.class));

    }
    public void fav(View view){
        fav.startAnimation(click);
        startActivity(new Intent(this,AccountingActivity.class));


    } public void notifications(View view){
        notifications.startAnimation(click);


    }
}
