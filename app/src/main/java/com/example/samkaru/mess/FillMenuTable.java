package com.example.samkaru.mess;

import android.content.Context;
import android.util.Log;

/**
 * Created by sam karu on 08/03/2018.
 */

public class FillMenuTable {
    Context  context;
    String[] meal_Name;
    String[] meal_day;
    String[] meal_time;
    int[] meal_price;

    public FillMenuTable(Context context){
        this.context = context;

    }
    public void insert() {
        MessDatabaseHelper helper = new MessDatabaseHelper(context);
        meal_Name = context.getResources().getStringArray(R.array.menuItems);
        meal_day = context.getResources().getStringArray(R.array.day);
        meal_time = context.getResources().getStringArray(R.array.time);
        meal_price = context.getResources().getIntArray(R.array.price);
        for (int i=0;i<meal_Name.length;i++) {
            helper.insertMenuRow(new MessDatabaseMenuContract(meal_Name[i],meal_day[i],meal_time[i],meal_price[i]));


        }







    }
}
