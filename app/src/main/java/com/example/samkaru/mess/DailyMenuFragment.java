package com.example.samkaru.mess;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


/**
 * Created by sam karu on 08/03/2018.
 */

public class DailyMenuFragment extends Fragment {
    private final static String KEY="which_day";
    ListView listView;
    String[] meal;
    String[] price;

    public DailyMenuFragment(){

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void onCreate(Bundle savesInstanceState){
        super.onCreate(savesInstanceState);
        String day = getArguments().getString(KEY);
        MessDatabaseHelper db= new MessDatabaseHelper(getContext());
        List<MessDatabaseMenuContract> list = db.getByDay(day);
        toArray(list);




    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.menu_fragments_layouts,container,false);
        listView =view.findViewById(R.id.menu_list);
        ArrayAdapter<String> adapter =new CustomAdapter(getActivity(),meal,price);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long id){
                Intent mealDetails = new Intent(getContext(),food_description_Activity.class);
                mealDetails.putExtra("mealName",meal[position]);
                startActivity(mealDetails);


            }



        });
        listView.setAdapter(adapter);



        return  view;

    }
    public void toArray(List<MessDatabaseMenuContract> list){
        MessDatabaseMenuContract menuItem;
        meal = new String[list.size()];
        price = new String[list.size()];
        int i=0;
        if(list.isEmpty()==false) {
            do {
                menuItem = list.remove(0);
                meal[i] = menuItem.getMeal_name();
                price[i] = "Ksh" + menuItem.getMeal_price();
                i++;


            } while (list.isEmpty() == false);
        }

    }
    public void onAttach(Context context){
        super.onAttach(context);


    }



}
