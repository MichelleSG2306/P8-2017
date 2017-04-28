package com.example.rasmus.p8_master;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class BankCard extends Card {

    public String bCCardNumber;
    public String bCAccountNumber;
    public String bCRegNumber;
    public String bCExpirationDate;
    public String bCSecurityNumber;
    public int bCAmount;

    public BankCard(){

    }

    public BankCard(String cardID, int cardCprNumber, String type, String bCCardNumber, String bCAccountNumber, String bCRegNumber, String bCExpirationDate, String bCSecurityNumber, int bCAmount) {
        super(cardID, cardCprNumber, type);
        this.bCCardNumber = bCCardNumber;
        this.bCAccountNumber = bCAccountNumber;
        this.bCRegNumber = bCRegNumber;
        this.bCExpirationDate = bCExpirationDate;
        this.bCSecurityNumber = bCSecurityNumber;
        this.bCAmount = bCAmount;
    }

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

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function


    }

    public String getbCCardNumber() {
        return bCCardNumber;
    }

    public String getbCAccountNumber() {
        return bCAccountNumber;
    }

    public String getbCRegNumber() {
        return bCRegNumber;
    }

    public String getbCExpirationDate() {
        return bCExpirationDate;
    }

    public String getbCSecurityNumber() {
        return bCSecurityNumber;
    }

    public int getbCAmount() {
        return bCAmount;
    }
}
