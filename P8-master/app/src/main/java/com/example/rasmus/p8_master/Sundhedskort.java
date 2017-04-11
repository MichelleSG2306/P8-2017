package com.example.rasmus.p8_master;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sundhedskort extends AppCompatActivity {

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundhedskort);
        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.sundhedskort_f, R.drawable.sundhedskort_b});
        viewPager.setAdapter(swipeAdapter);
        //Swipe Function
    }
}
