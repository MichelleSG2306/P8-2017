package com.example.rasmus.p8_master;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class BankCard extends AppCompatActivity {

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card);
        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.bankcard_f, R.drawable.bankcard_b});
        viewPager.setAdapter(swipeAdapter);
        //Swipe Function


    }
}
