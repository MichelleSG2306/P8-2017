package com.example.rasmus.p8_master;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ungdomskort extends AppCompatActivity {

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ungdomskort);
        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.ungdomskort_f, R.drawable.ungdomskort_b});
        viewPager.setAdapter(swipeAdapter);
        //Swipe Function
    }
}
