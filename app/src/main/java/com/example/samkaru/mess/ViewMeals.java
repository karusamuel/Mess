package com.example.samkaru.mess;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

/**
 * Created by sam karu on 08/03/2018.
 */

public class ViewMeals extends AppCompatActivity {
    ListView listView;
    String[] name;
    TextView dailyCost;
    MessDatabaseSavedContract saved;
    int[] price;
    int cost=0;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewmeals_activity_layout);
        listView=findViewById(R.id.listView);
        dailyCost=findViewById(R.id.dayCost);


        MessDatabaseHelper db = new MessDatabaseHelper(this);
        Intent n = getIntent();
       List<MessDatabaseSavedContract> list = db.getByDatePurchased(n.getStringExtra("Date"));


       if(list.isEmpty()==false){
           name = new String[list.size()];
           int i =0;
           while(!list.isEmpty()){

               saved = list.remove(0);
               name[i]= saved.getMeal();
               cost = cost+saved.getPrice();
               i++;





           }
           this.setTitle(n.getStringExtra("Date"));
           listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name));
           dailyCost.setText("Total Day Cost = "+Integer.toString(cost));



       }





    }
}
