package com.example.samkaru.mess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.List;

public class AccountingActivity extends AppCompatActivity {
    String[] saved;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accounting_activity_layout);
        listview = findViewById(R.id.kk);
        MessDatabaseHelper db =new MessDatabaseHelper(this);

        List<MessDatabaseSavedContract>  list;

        list = db.getAll();

        saved =new String[list.size()];
        Log.e("here","failed here");
        int i=0;

        if(list.size()>0){
            while(list.isEmpty() != true){
              MessDatabaseSavedContract mess =  list.remove(0);
              saved[i] = mess.getDate();
              i++;

            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,saved);

            listview.setAdapter(adapter);












        }

        listview.setOnItemClickListener(new ListView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long id){
            Intent n = new Intent(getApplicationContext(),ViewMeals.class);
            n.putExtra("Date",saved[position]);
            startActivity(n);

            }
        });






    }

}
