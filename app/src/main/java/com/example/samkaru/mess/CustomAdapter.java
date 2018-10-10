package com.example.samkaru.mess;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by sam karu on 17/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<String> {
    String[] item;
    String[] price;
    private Activity context;
    public CustomAdapter(Activity context,String[] item,String[] price){
        super(context,R.layout.custom_listview_layout,item);
        this.item=item;
        this.price=price;
        this.context=context;


    }

    public View getView(int position, View view, ViewGroup viewGroup){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.custom_listview_layout,null,true);
       TextView itemView = rowView.findViewById(R.id.item);
       TextView priceView = rowView.findViewById(R.id.price);

       itemView.setText( item[position] );
       priceView.setText( price[position] );

       return rowView;



    }
}
