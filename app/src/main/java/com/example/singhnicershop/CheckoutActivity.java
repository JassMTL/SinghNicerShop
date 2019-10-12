package com.example.singhnicershop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent intent = getIntent();

        intent.getStringExtra(MenuActivity.SUBTOTALTAG);
        intent.getStringExtra(MenuActivity.SUBTOTALTAG);
    }
}
