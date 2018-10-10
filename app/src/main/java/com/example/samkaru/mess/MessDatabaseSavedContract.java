package com.example.samkaru.mess;

/**
 * Created by sam karu on 22/02/2018.
 */

public class MessDatabaseSavedContract {
    private String meal;
    private String date;
    private  int price;
    private  int id;


    public MessDatabaseSavedContract(){

    }
    public MessDatabaseSavedContract(String meal, String date, int price){
        this.meal=meal;
        this.date=date;
        this.price=price;

    }
    public MessDatabaseSavedContract(String meal){
        this.meal = meal;

    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return id;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
