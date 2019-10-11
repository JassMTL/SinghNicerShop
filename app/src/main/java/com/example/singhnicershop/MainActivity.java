package com.example.singhnicershop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //added a comment
    }

    /**
     * launches the menuActivity
     * @param view
     */
    public void launchMenu(View view) {
        //intention to use to activate the secondactily
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
