package com.example.rasmus.p8_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class Rejsekort extends Card {



    //Variables to use on each object
    public String id;
    public String cardNumber;
    public int amount;

    //Constructors
    public Rejsekort(){
    }

    public Rejsekort(String id, String cardNumber, int amount){
        this.id = id;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejsekort);
          
            //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.rejsekort_f, R.drawable.rejsekort_b});
        viewPager.setAdapter(swipeAdapter);

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function

    }

    //get methods
    public String getRejsekortId(){
        return id;
    }

    public String getRejsekortCardnumber(){
        return cardNumber;
    }

    public int getRejsekortAmount(){
        return amount;
    }

}
