package com.example.rasmus.p8_master;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ungdomskort extends Card {

    public String uKCardNumber;
    public String uKtravelZone;
    public String uKIssuedDate;
    public String uKExpirationDate;
    public String uKDateOfBirth;

    public Ungdomskort() {

    }

    public Ungdomskort(String uKCardNumber, String uKtravelZone, String uKIssuedDate, String uKExpirationDate, String uKDateOfBirth) {
        this.uKCardNumber = uKCardNumber;
        this.uKtravelZone = uKtravelZone;
        this.uKIssuedDate = uKIssuedDate;
        this.uKExpirationDate = uKExpirationDate;
        this.uKDateOfBirth = uKDateOfBirth;
    }

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

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function
    }

    public String getuKCardNumber() {
        return uKCardNumber;
    }

    public String getuKtravelZone() {
        return uKtravelZone;
    }

    public String getuKIssuedDate() {
        return uKIssuedDate;
    }

    public String getuKExpirationDate() {
        return uKExpirationDate;
    }

    public String getuKDateOfBirth() {
        return uKDateOfBirth;
    }
}
