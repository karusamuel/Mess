package com.example.samkaru.mess;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class food_description_Activity extends AppCompatActivity {
    ImageView imageView;
    TextView meal_description;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_description);

        Intent sam = getIntent();
        String meal = sam.getStringExtra("mealName");
        imageView = findViewById(R.id.imageView);
        meal_description = findViewById(R.id.meal_description);
        collapsingToolbarLayout = findViewById(R.id.collapsing_tool_bar);


        toolbar = findViewById(R.id.mess_food);
        setSupportActionBar(toolbar);

        switch (meal) {
            case "Rice":
                collapsingToolbarLayout.setTitle("Rice");
                imageView.setImageResource(R.drawable.rice);
                meal_description.setText(R.string.rice);
                break;
            case "Green Grams/Fried Beans":
                collapsingToolbarLayout.setTitle("Green Grams");
                imageView.setImageResource(R.drawable.beans);
                meal_description.setText(R.string.beans);
                break;
            case "Chapati":
                collapsingToolbarLayout.setTitle("Chapati");
                imageView.setImageResource(R.drawable.chapati);
                meal_description.setText(R.string.chapati);
                break;
            case "Bread With Margarine":
                collapsingToolbarLayout.setTitle("Bread With Margarine");
                imageView.setImageResource(R.drawable.loaf);
                meal_description.setText(R.string.bread);
                break;
            case "Pilau":
                collapsingToolbarLayout.setTitle("Pilau");
                imageView.setImageResource(R.drawable.pilau);
                meal_description.setText(R.string.pilau);
                break;
            case "Vegetables":
                collapsingToolbarLayout.setTitle("Vegetables");
                imageView.setImageResource(R.drawable.vegetables);
                meal_description.setText(R.string.vegetables);

                break;
            case "Tea":
                collapsingToolbarLayout.setTitle("Tea");
                imageView.setImageResource(R.drawable.tea);
                meal_description.setText(R.string.tea);

                break;
            case "Sausage":
                collapsingToolbarLayout.setTitle("Sausage");
                imageView.setImageResource(R.drawable.sausage);
                meal_description.setText(R.string.sausage);

                break;
            case "Beef Stew":
                collapsingToolbarLayout.setTitle("Beef Stew");
                imageView.setImageResource(R.drawable.beefstew);
                meal_description.setText(R.string.beefstew);

                break;
            case "Githeri":
                    collapsingToolbarLayout.setTitle("Githeri");
                imageView.setImageResource(R.drawable.githeri1);
                meal_description.setText(R.string.githeri);

                break;
            case "Bajia":
                collapsingToolbarLayout.setTitle("Bajia");
                imageView.setImageResource(R.drawable.bajia);
                meal_description.setText(R.string.bajia);

                break;
            case "Fried Beef":
                collapsingToolbarLayout.setTitle("Fried Beef");
                imageView.setImageResource(R.drawable.friedbeef);
                meal_description.setText(R.string.friedbeef);

                break;
            case "Mahamri":
                collapsingToolbarLayout.setTitle("Mahamri");
                imageView.setImageResource(R.drawable.mahamri);
                meal_description.setText(R.string.mahamri);

                break;
            case "Fried Potatoes":
                collapsingToolbarLayout.setTitle("Fried Potatoes");
                imageView.setImageResource(R.drawable.potatoes);
                meal_description.setText(R.string.potatoes);

                break;
            case "Salad":
                collapsingToolbarLayout.setTitle("Salad");
                imageView.setImageResource(R.drawable.salad);
                meal_description.setText(R.string.salad);

                break;
            case "Stewed Potatoes":
                collapsingToolbarLayout.setTitle("Stewed Potatoes");
                imageView.setImageResource(R.drawable.stewedpotatoes);
                meal_description.setText(R.string.stewedpotatoes);

                break;
            case "Ugali":
                collapsingToolbarLayout.setTitle("Ugali");
                imageView.setImageResource(R.drawable.ugali);
                meal_description.setText(R.string.ugali);

                break;
            case "Stewed Beef":
                collapsingToolbarLayout.setTitle("Stewed Beef");
                imageView.setImageResource(R.drawable.beefstew);
                meal_description.setText(R.string.stewedbeef);

                break;

            default:


        }
    }
}
