package com.example.samkaru.mess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sam karu on 17/02/2018.
 */

public class CalculatorActivity extends AppCompatActivity {
    Intent calc;
    int[] selected;
    int[] price;
    String[] items;
    String[] list;
    int[] costArray;
    int n;
    static int length=0;
    ListView listView;
    int cost =0;
    TextView total;
    FloatingActionButton ft;
    CoordinatorLayout cc;
    ArrayAdapter<String> stringArrayAdapter;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_activity_layout);

        calc = getIntent();

        listView=findViewById(R.id.selected);
        n = calc.getIntExtra("length",-1);
        selected = calc.getIntArrayExtra("selected");
        items = calc.getStringArrayExtra("name");
        list = new String[n];
        cc = findViewById(R.id.main);
        costArray =new int[n];
        total =findViewById(R.id.total);
        price = calc.getIntArrayExtra("priceList");


        ft = findViewById(R.id.floatingActionButton2);
        ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.length>0){
                    SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy");
                    for(int i =0;i<=list.length-1;i++){
                        Date c =  Calendar.getInstance().getTime();





                        save(list[i],format.format(c),costArray[i]);

                    }

                    Snackbar snackbar =Snackbar.make(cc,"Saved",Snackbar.LENGTH_SHORT);
                    snackbar.show();


                    new Thread(new Runnable(){
                        public void run(){
                            try{
                                Thread.sleep(2000);




                            }catch(InterruptedException ie){

                                Log.e("Holdup", "run:failed to wait " );


                            }
                            listView.post(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                }
                            });

                        }

                    }).start();







                }
                else{
                    Snackbar snackbar =Snackbar.make(cc,"Nothing Selected",Snackbar.LENGTH_SHORT);
                    snackbar.show();


                }

            }
        });



        for(int i=n-1;i>=0;i--){
            cost =cost+price[selected[i]];
            costArray[i] = price[selected[i]];
            list[i] = items[selected[i]];
            length++;
        }

        stringArrayAdapter  = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        listView.setAdapter(stringArrayAdapter);
        total.setText("Total = "+Integer.toString(cost));



    }
    public void save(String meal,String date,int price){
        MessDatabaseHelper messdb = new MessDatabaseHelper(this);
        messdb.insertRow(new MessDatabaseSavedContract(meal,date,price));
    }
}
