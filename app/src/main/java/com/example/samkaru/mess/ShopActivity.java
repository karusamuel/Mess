package com.example.samkaru.mess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by sam karu on 16/02/2018.
 */

public class ShopActivity extends AppCompatActivity {
    ListView menuList;
    FloatingActionButton btn;
    Intent n;
    String[] name;
    String[] price;
    int[] priceList;
    int number=0;

    int[] selected;
    static int length;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_layout);
        menuList =findViewById(R.id.list);
        fetch();
        n = new Intent(getApplicationContext(),CalculatorActivity.class);
        CustomAdapter cartAdapter =new CustomAdapter(this,name, price);

        btn = findViewById(R.id.floatingActionButton3);
        btn.setImageDrawable(getResources().getDrawable(R.drawable.ic_gamepad_white_18dp));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n.putExtra("selected",selected);
                n.putExtra("length",length);
                n.putExtra("name",name);
                n.putExtra("priceList",priceList);
                startActivity(n);

            }
        });

        menuList.setAdapter(cartAdapter);
        menuList.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               number++;
                array(i);
                setQuantity(number);




            }
        });

    }
    public void array(int i){
       selected[length]=i;
       length++;




    }
    public void onStart(){
        super.onStart();
        selected= new int[100];
        length=0;


    }
    public void fetch(){
        MessDatabaseHelper db = new MessDatabaseHelper(this);
        List<MessDatabaseMenuContract>  list= db.getWholeMenu();
        MessDatabaseMenuContract menu;
        int i=0;
        name = new String[list.size()];
        price = new String[list.size()];
        priceList = new int[list.size()];
        if(!list.isEmpty()){
            while(!list.isEmpty()) {
                menu = list.remove(0);
                name[i] = menu.getMeal_name();
                price[i] = "Ksh" + menu.getMeal_price();
                priceList[i] = menu.getMeal_price();
                i++;
            }


        }
    }


public void setQuantity(int number){
        if (number <2 ){
            this.setTitle(Integer.toString(number)+" Item Selected");
        }else{
            this.setTitle(Integer.toString(number)+" Items Selected");
        }
}

}
