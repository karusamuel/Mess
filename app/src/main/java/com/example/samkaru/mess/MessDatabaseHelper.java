package com.example.samkaru.mess;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by sam karu on 22/02/2018.
 */

public class MessDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="budgetMess";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME1="budgetMessTable";
    private static final String KEY_MEAL="meal";
    private static final String KEY_DATE="buyingDate";
    private static final String KEY_PRICE="price";
    private static final String KEY_ID="_id";



    private static final String KEY_ID2="_id";
    private static final String TABLE_NAME2="Menu_mess_table";
    private static final String KEY_MEAL_NAME="meal_name";
    private static final String KEY_MEAL_TIME="meal_time";
    private static final String KEY_MEAL_DAY="meal_day";
    private static final String KEY_MEAL_PRICE="meal_price";
    Context context;


    public MessDatabaseHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context =context;


    }


    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+TABLE_NAME1 +"("+
                KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                KEY_MEAL + " TEXT," +
                KEY_DATE  + " TEXT," +
                KEY_PRICE + " TEXT" +


                ")");
        db.execSQL("CREATE TABLE "+TABLE_NAME2+" ("+
                KEY_ID2+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                KEY_MEAL_NAME+" TEXT,"+
                KEY_MEAL_DAY+" TEXT,"+
                KEY_MEAL_TIME+" TEXT,"+
                KEY_MEAL_PRICE +" INTEGER )"


        );


    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("Drop TABLE IF EXISTS " +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "  +TABLE_NAME2);

        onCreate(db);

    }

    // SQL  CRUD operations ie create read update delete;
    public List<MessDatabaseSavedContract> getAll(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<MessDatabaseSavedContract> messDatabaseSavedContractList = new ArrayList<MessDatabaseSavedContract>();
        Cursor cursor = db.rawQuery("SELECT DISTINCT "+KEY_DATE +" FROM "+TABLE_NAME1,null);
        if(cursor.moveToFirst()){
            do{
                MessDatabaseSavedContract mess = new MessDatabaseSavedContract();
                mess.setDate(cursor.getString(0));


                messDatabaseSavedContractList.add(mess);
            }while(cursor.moveToNext());
        }
        return messDatabaseSavedContractList;

    }
    public void insertRow(MessDatabaseSavedContract mc){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEAL,mc.getMeal());
        values.put(KEY_DATE,mc.getDate());
        values.put(KEY_PRICE,mc.getPrice());

        db.insert(TABLE_NAME1,null,values);

    }
    public List<MessDatabaseSavedContract> getByDatePurchased(String date){
        SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor =  db.rawQuery("Select " + KEY_MEAL + ","
                      + KEY_PRICE + " FROM "+ TABLE_NAME1+" WHERE "+KEY_DATE+"=?",
              new String[]{date});
      List<MessDatabaseSavedContract> list =new ArrayList<MessDatabaseSavedContract>();
      if(cursor.moveToFirst()){
          do{
              MessDatabaseSavedContract cont = new MessDatabaseSavedContract();
              cont.setMeal(cursor.getString(0));
              cont.setPrice(cursor.getInt(1));
              list.add(cont);
          }while(cursor.moveToNext());



      }

      return list;



    }

    public void insertMenuRow(MessDatabaseMenuContract mc){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MEAL_NAME,mc.getMeal_name());
        values.put(KEY_MEAL_PRICE,mc.getMeal_price());
        values.put(KEY_MEAL_DAY,mc.getMeal_day());
        values.put(KEY_MEAL_TIME,mc.getMeal_time());
        db.insert(TABLE_NAME2,null,values);


    }
    public List<MessDatabaseMenuContract> getWholeMenu(){
        List<MessDatabaseMenuContract> list= new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
       Cursor c = db.rawQuery("SELECT "+KEY_MEAL_NAME+","+KEY_MEAL_PRICE+" FROM "+TABLE_NAME2,null);
       if (c.moveToFirst()){
           do{
               MessDatabaseMenuContract mc =new MessDatabaseMenuContract();
               mc.setMeal_name(c.getString(0));
               mc.setMeal_price(c.getInt(1));
               list.add(mc);
           }while(c.moveToNext());


       }
       return list;


    }
    public List<MessDatabaseMenuContract> getByDay(String day){
        List<MessDatabaseMenuContract> list= new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT "+KEY_MEAL_NAME+","+KEY_MEAL_PRICE+" FROM "+TABLE_NAME2 +
                        " WHERE "+KEY_MEAL_DAY+" Like ? or "+KEY_MEAL_DAY +" like ? "
                        , new String[]{"%Everyday%",day});
        if (c.moveToFirst()){
            do{
                MessDatabaseMenuContract mc =new MessDatabaseMenuContract();
                mc.setMeal_name(c.getString(0));
                mc.setMeal_price(c.getInt(1));
                list.add(mc);
            }while(c.moveToNext());


        }
        return list;



    }
    public List<MessDatabaseMenuContract> getByTime(String time){
        List<MessDatabaseMenuContract> list= new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT "+KEY_MEAL_NAME+","+KEY_MEAL_PRICE+" FROM "+TABLE_NAME2 +"" +
                        " WHERE "+KEY_MEAL_TIME+" like ? ",new String[]{time});
        if (c.moveToFirst()){
            do{
                MessDatabaseMenuContract mc =new MessDatabaseMenuContract();
                mc.setMeal_name(c.getString(0));
                mc.setMeal_price(c.getInt(1));
                list.add(mc);
            }while(c.moveToNext());


        }
        return list;


    }

}
