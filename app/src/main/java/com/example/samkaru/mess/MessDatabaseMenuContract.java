package com.example.samkaru.mess;

/**
 * Created by sam karu on 08/03/2018.
 */

public class MessDatabaseMenuContract {
    private String meal_name;
    private String meal_day;
    private String meal_time;
    private int meal_price;
    public MessDatabaseMenuContract(){

    }
    public  MessDatabaseMenuContract(String meal_name,String meal_day,String meal_time,int meal_price){
       this.meal_name = meal_name;
       this.meal_day = meal_day;
       this.meal_price = meal_price;
       this.meal_time = meal_time;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getMeal_day() {
        return meal_day;
    }

    public void setMeal_day(String meal_day) {
        this.meal_day = meal_day;
    }

    public String getMeal_time() {
        return meal_time;
    }

    public void setMeal_time(String meal_time) {
        this.meal_time = meal_time;
    }

    public int getMeal_price() {
        return meal_price;
    }

    public void setMeal_price(int meal_price) {
        this.meal_price = meal_price;
    }
}
