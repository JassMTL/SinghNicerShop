package com.example.singhnicershop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    private TextView showSubtotal;
    private TextView showGst;
    private TextView showQst;
    private TextView showFinalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();

        double subtotal = intent.getDoubleExtra(MenuActivity.SUBTOTALTAG,0);
        double shipping = intent.getDoubleExtra(MenuActivity.SHIPPINGTAG,0);
        //String subtotalStr = intent.getStringExtra(MenuActivity.SUBTOTALTAG,0);
        //String shippingStr =intent.getStringExtra(MenuActivity.SHIPPINGTAG);

        Log.d("subtotal",""+subtotal);
        showTax(subtotal,shipping);
    }

    public void showTax(double subtotal,double shipping) {
        showSubtotal = (TextView) findViewById(R.id.valBeforeTax);
        showGst = (TextView) findViewById(R.id.valGst);
        showQst = (TextView) findViewById(R.id.valQst);
        showFinalPrice = (TextView) findViewById(R.id.valFinal);

        double valueGst = subtotal * 0.05;
        double valueQst = subtotal * 0.09975;
        double finalPrice = subtotal + valueGst + valueQst;

        showSubtotal.setText(String.format("$%.2f",subtotal));
        showGst.setText(String.format("$%.2f",valueGst));
        showQst.setText(String.format("$%.2f",valueQst));
        showFinalPrice.setText(String.format("$%.2f",finalPrice));
    }
}

