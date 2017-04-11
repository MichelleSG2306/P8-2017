package com.example.rasmus.p8_master;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DriversLicence extends AppCompatActivity {

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_lisence);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.driverslicence_f, R.drawable.driverslicence_b});
        viewPager.setAdapter(swipeAdapter);
    }
}
