package com.example.singhnicershop;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.singhnicershop.model.ShoppingItems;

import java.util.ArrayList;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
     static final String SUBTOTALTAG = "com.example.android.singhnicershop.SUBTOTOTAL";
     static final String SHIPPINGTAG = "com.example.android.singhnicershop.SHIPPING";

    private final LinkedList<ShoppingItems> mList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    int shippingCost = 0;
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
                final String [] options = {"express($50)","regular($10)","no hurry(no cost)"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Choose Shipping option");

                int checkedItem = -1;

                builder.setSingleChoiceItems(options, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        switch (position){
                            case 0: shippingCost += 50;
                            break;
                            case 1: shippingCost += 50;
                            break;
                            case 2: shippingCost += 50;
                            break;

                        }
                    }
                });
                builder.setPositiveButton("Proceed to checkout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        gotoCheckout();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        shippingCost = 0;
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

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
        String subtotal = getResources().getString(R.string.defaultNum);

        for(int i = 0; i < title.length;i++){
            mList.add(new ShoppingItems(title[i],description[i],price[i],image[i],quantity,subtotal));
        }


        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ProductAdapter(this,mList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public  void gotoCheckout(){
        int totalSubtotal = 0;
        for (int i = 0; i < mList.size();i++){
            totalSubtotal += Double.parseDouble(mList.get(i).getSubtotal());
        }
        Intent intent = new Intent(this, CheckoutActivity.class);
        intent.putExtra(SHIPPINGTAG, shippingCost);
        intent.putExtra(SUBTOTALTAG, totalSubtotal);
        startActivity(intent);
    }

    protected void onCreateOptionsMenu(Bundle savedInstanceState) {

    }
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        ArrayList<String> test = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            test.add(mList.get(i).getQuantity());
            test.add(mList.get(i).getSubtotal());
        }

        savedInstanceState.putStringArrayList("Array",test);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> test = savedInstanceState.getStringArrayList("Array");

        Log.d("Checker",test.get(0));

        for(int i = 0,j = 0; i < 3; i++,j+=2){
            mList.get(i).setQuantity(test.get(j));

        }
        for(int i = 0,j = 1; i < 3; i++,j+=2){
            mList.get(i).setSubtotal(test.get(j));

        }
    }

}
