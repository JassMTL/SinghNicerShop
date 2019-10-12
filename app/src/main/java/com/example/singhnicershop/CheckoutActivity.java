package com.example.singhnicershop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    //text view for every element
    private TextView showSubtotal;
    private TextView showGst;
    private TextView showQst;
    private TextView showFinalPrice;
    private TextView showShipping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //get info fom intent
        Intent intent = getIntent();
        double subtotal = intent.getDoubleExtra(MenuActivity.SUBTOTALTAG,0);
        double shipping = intent.getDoubleExtra(MenuActivity.SHIPPINGTAG,0);
        Log.d("subtotal",""+subtotal);
        showTax(subtotal,shipping);
    }

    public void showTax(double subtotal,double shipping) {
        //find elements by id
        showSubtotal = (TextView) findViewById(R.id.valBeforeTax);
        showGst = (TextView) findViewById(R.id.valGst);
        showQst = (TextView) findViewById(R.id.valQst);
        showFinalPrice = (TextView) findViewById(R.id.valFinal);
        showShipping = (TextView) findViewById(R.id.valShipping);

        //does calculation for tax
        //subtotal +=shipping;
        double finalSubtotal = subtotal + shipping;
        double valueGst = finalSubtotal * 0.05;
        double valueQst = finalSubtotal * 0.09975;
        double finalPrice = finalSubtotal + valueGst + valueQst;

        //shows string
        showSubtotal.setText(String.format("$%.2f",subtotal));
        showGst.setText(String.format("$%.2f",valueGst));
        showQst.setText(String.format("$%.2f",valueQst));
        showFinalPrice.setText(String.format("$%.2f",finalPrice));
        showShipping.setText(String.format("$%.2f",shipping));
    }
}

