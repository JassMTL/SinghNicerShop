package com.example.singhnicershop;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.singhnicershop.model.ShoppingItems;

import java.util.ArrayList;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
     static final String SUBTOTALTAG = "com.example.android.singhnicershop.SUBTOTOTAL";
     static final String SHIPPINGTAG = "com.example.android.singhnicershop.SHIPPING";

    private final LinkedList<ShoppingItems> mList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    double shippingCost;
    int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shippingCost = 0;
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
//shows the shipping price and links to checkiout
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
                            case 1: shippingCost += 10;
                            break;
                            case 2: shippingCost += 0;
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

        //all the informations about view

        String [] title = {
                getResources().getString(R.string.sarbloh_karra),
                getResources().getString(R.string.kirpan),
                getResources().getString(R.string.pendant),
                getResources().getString(R.string.titleBaj),
                getResources().getString(R.string.titlefiftee),

                getResources().getString(R.string.titlewax),
                getResources().getString(R.string.titlecomb),
                getResources().getString(R.string.titlechola),
                getResources().getString(R.string.titlegatra),
                getResources().getString(R.string.titlejutti)
        };

        String [] description = {
                getResources().getString(R.string.descKarra),
                getResources().getString(R.string.descriptionKirpan),
                getResources().getString(R.string.descriptionPendant),
                getResources().getString(R.string.descBaj),
                getResources().getString(R.string.descfiftee),

                getResources().getString(R.string.descwax),
                getResources().getString(R.string.desccomb),
                getResources().getString(R.string.descchola),
                getResources().getString(R.string.descgatra),
                getResources().getString(R.string.descjutti)
        };

        String [] price = {
                getResources().getString(R.string.priceKarraStr),
                getResources().getString(R.string.priceKirpanStr),
                getResources().getString(R.string.pricePendant),
                getResources().getString(R.string.priceBaj),
                getResources().getString(R.string.pricefiftee),

                getResources().getString(R.string.pricewax),
                getResources().getString(R.string.pricecomb),
                getResources().getString(R.string.pricechola),
                getResources().getString(R.string.pricegatra),
                getResources().getString(R.string.pricejutti)
        };

        int [] image = {
                R.drawable.karra,
                R.drawable.kirpan,
                R.drawable.khanda,
                R.drawable.baj,
                R.drawable.fiftee,

                R.drawable.wax,
                R.drawable.comb,
                R.drawable.chola,
                R.drawable.gatra,
                R.drawable.jutti
        };
        size = title.length;
        Log.d("size",""+size);

        String quantity = getResources().getString(R.string.defaultNum);
        String subtotal = getResources().getString(R.string.defaultNum);

        //adds to list witht he help of shoppingitems class
        Log.d("lenght",""+title.length);
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

    //calculates subtotal and sends total and shipping to checkout
    public  void gotoCheckout(){
        double totalSubtotal = 0;
        for (int i = 0; i < mList.size();i++){
            totalSubtotal += Double.parseDouble(mList.get(i).getSubtotal());
        }
        Intent intent = new Intent(this, CheckoutActivity.class);
        Log.d("lenght",""+shippingCost);

        intent.putExtra(SHIPPINGTAG, shippingCost);
        intent.putExtra(SUBTOTALTAG, totalSubtotal);
        startActivity(intent);
    }
    protected void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        ArrayList<String> test = new ArrayList<>();
        for(int i = 0; i < size; i++){
            test.add(mList.get(i).getQuantity());
            test.add(mList.get(i).getSubtotal());
        }

        savedInstanceState.putStringArrayList("Array",test);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> test = savedInstanceState.getStringArrayList("Array");

        Log.d("Checker",test.get(0));

        for(int i = 0,j = 0; i < size; i++,j+=2){
            mList.get(i).setQuantity(test.get(j));

        }
        for(int i = 0,j = 1; i < size; i++,j+=2){
            mList.get(i).setSubtotal(test.get(j));

        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    //Information about the menu
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        String montrealaddress = getString(R.string.montreal_location) +" :8350 jeanne-mance";
        String torontoaddress = getString(R.string.toronto_location) + " :4725 Dixie Rd";
        String vancouveraddress = getString(R.string.vancouver_location) + " :1716 Willy avenue";
        Toast toast;
        switch (item.getItemId()) {
            case R.id.montrealLocation:
                toast = Toast.makeText(this, montrealaddress, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.torontoLocation:
                toast = Toast.makeText(this,torontoaddress, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.vancouverLocation:
                toast = Toast.makeText(this,vancouveraddress, Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
