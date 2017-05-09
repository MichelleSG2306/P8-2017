package com.example.rasmus.p8_master;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class NewCard extends Card {

    public String barcode;
    public String nameOfCard;

    public NewCard(){

    }

    public NewCard(String cardID, String type, int frontPhoto, int backPhoto, String barcode, String nameOfCard) {
        super(cardID, type, frontPhoto, backPhoto);
        this.barcode = barcode;
        this.nameOfCard = nameOfCard;
    }

    SwipeAdapter swipeAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);

        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.rejsekort_f, R.drawable.rejsekort_b});
        viewPager.setAdapter(swipeAdapter);

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);


    }

    public String getBarcode() {
        return barcode;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }
}
