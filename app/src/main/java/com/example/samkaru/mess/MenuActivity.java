package com.example.samkaru.mess;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.prefs.Preferences;

/**
 * Created by sam karu on 16/02/2018.
 */

public class MenuActivity extends AppCompatActivity {
//    ListView menuList;
    FloatingActionButton btn;
    ViewPager viewPager;
    TabLayout tabLayout;
    SharedPreferences setting;
    private final static String MODE="Display_mode";
    public final static String KEY ="which_day";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_layout);

        viewPager = findViewById(R.id.viewPager);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager,true);

        setting = PreferenceManager.getDefaultSharedPreferences(this);

        MessDatabaseHelper db = new MessDatabaseHelper(this);

        btn = findViewById(R.id.floatingActionButton);
        btn.setRippleColor(Color.CYAN);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                startActivity(new Intent(getApplicationContext(),ShopActivity.class));
            }


        });



        if(db.getWholeMenu().isEmpty()){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new FillMenuTable(getApplicationContext()).insert();
                }
            }).start();

        }

        if(setting.getString("menu_settings","-1").equalsIgnoreCase("show_by_day")) {
            addFragmentsDaily();

        }
        else{

            addFragmentsMeals();
            Toast.makeText(this,setting.getString("menu_settings","-1"),Toast.LENGTH_LONG).show();

        }










    }
    private void addFragmentsMeals(){
        ViewPagerStateAdapter adapter = new ViewPagerStateAdapter(getSupportFragmentManager());
        adapter.addFrag(new BreakFirstFragment(), "BreakFirst");
        adapter.addFrag(new LunchFragment(), "Lunch");
        adapter.addFrag(new SupperFragment(), "Supper");

        viewPager.setAdapter(adapter);

    }

    private void addFragmentsDaily() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFrag(getFrag("%Sunday%"),"Sunday");
        adapter.addFrag(getFrag("%Monday%"),"Monday");
        adapter.addFrag(getFrag("%Tuesday%"),"Tuesday");
        adapter.addFrag(getFrag("%Wednesday%"),"Wednesday");
        adapter.addFrag(getFrag("%Thursday%"),"Thursday");
        adapter.addFrag(getFrag("%Friday%"),"Friday");
        adapter.addFrag(getFrag("%Saturday%"), "Saturday");



        viewPager.setAdapter(adapter);

    }
    public int today(){
        Calendar calendar = Calendar.getInstance();



            return calendar.getTime().getDay();



    }
    private Bundle date(String date){
        Bundle args = new Bundle();
        args.putString(KEY,date);
        return  args;
    }
    private Fragment getFrag(String date){
        Fragment fragment=new DailyMenuFragment();
        fragment.setArguments(date(date));
        return fragment;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
       private List<Fragment> fragmentList=new ArrayList<>();
       private List<String> fragmentTitleList=new ArrayList<>();
       public ViewPagerAdapter(FragmentManager manager){
           super(manager);

       }
       public Fragment getItem(int position){
           return fragmentList.get(position);
       }
       public int getCount(){
           return fragmentList.size();
       }
       public String getPageTitle(int position){
         return fragmentTitleList.get(position);
       }
       public void addFrag(Fragment fragment,String title){
           this.fragmentList.add(fragment);
           this.fragmentTitleList.add(title);

       }

    }
    class ViewPagerStateAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragmentList=new ArrayList<>();
        private List<String> fragmentTitleList=new ArrayList<>();
        public ViewPagerStateAdapter(FragmentManager manager){
            super(manager);

        }
        public Fragment getItem(int position){
            return fragmentList.get(position);
        }
        public int getCount(){
            return fragmentList.size();
        }
        public String getPageTitle(int position){
            return fragmentTitleList.get(position);
        }
        public void addFrag(Fragment fragment,String title){
            this.fragmentList.add(fragment);
            this.fragmentTitleList.add(title);

        }

    }
    public void onResume(){
        super.onResume();
        if(setting.getString("menu_settings","-1").equalsIgnoreCase("show_by_day")){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {

                    }
                    btn.post(new Runnable() {
                        @Override
                        public void run() {

                            viewPager.setCurrentItem(today(), true);



                        }
                    });

                }

            }).start();
        }

    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);

    }

    public  boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.settings:
                   startActivity(new Intent(getApplicationContext(),Settings.class));
                return true;


            default:
             return super.onOptionsItemSelected(item);
        }


    }




}
