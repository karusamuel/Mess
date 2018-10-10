package com.example.samkaru.mess;

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
 * Created by sam karu on 05/03/2018.
 */

public class SupperFragment extends Fragment {
    Context context;
    ListView listView;
    String[] menuItem;
    String[] menuItemPrice;
    public SupperFragment(){

    }
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.menu_fragments_layouts,container,false);
        listView = view.findViewById(R.id.menu_list);

        ArrayAdapter<String> adapter = new CustomAdapter(getActivity(),menuItem,menuItemPrice);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> adapterView,View view,int position,long id){
                Intent mealDetails = new Intent(getContext(),food_description_Activity.class);
                mealDetails.putExtra("mealName",menuItem[position]);
                startActivity(mealDetails);


            }



        });
        listView.setAdapter(adapter);



        return view;

    }
    public void onAttach(Context context){
        super.onAttach(context);
        this.context=context;
        populate();

    }
    public void populate(){

        MessDatabaseHelper db = new MessDatabaseHelper(getContext());
        List<MessDatabaseMenuContract> list = db.getByTime("%Supper%");
        menuItem=new String[list.size()];
        menuItemPrice = new String[list.size()];
        int i =0;

        if(list.size()>0){
            while(list.size()>0) {
                MessDatabaseMenuContract menu = list.remove(0);
                menuItem[i] = menu.getMeal_name();
                menuItemPrice[i] ="Ksh"+ menu.getMeal_price();
                i++;
            }

            setListAdapter();

        }




    }
    public void setListAdapter(){



    }


}
