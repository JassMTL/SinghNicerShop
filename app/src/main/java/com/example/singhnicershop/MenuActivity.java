package com.example.singhnicershop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.singhnicershop.model.ShoppingItems;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        String [] title = {
                getResources().getString(R.string.sarbloh_karra),
                getResources().getString(R.string.kirpan),
                getResources().getString(R.string.pendant)
        };

        String [] description = {
                getResources().getString(R.string.descKarra),
                getResources().getString(R.string.descriptionKirpan),
                getResources().getString(R.string.descriptionPendant)
        };

        String [] price = {
                getResources().getString(R.string.priceKarraStr),
                getResources().getString(R.string.priceKirpanStr),
                getResources().getString(R.string.pricePendant)
        };

        int [] image = {
                R.drawable.karra,
                R.drawable.kirpan,
                R.drawable.khanda
        };

        String quantity = getResources().getString(R.string.defaultNum);

        for(int i = 0; i < title.length;i++){
            new ShoppingItems(title[i],description[i],price[i],image[i],quantity);
        }
    }

}
