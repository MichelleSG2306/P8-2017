package com.example.rasmus.p8_master;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Sundhedskort extends Card {

    //Variables to use on each object
    public String sUid;
    public String sUAddress;
    public String sURegion;
    public String sUMunicipality;
    public String sUDoctorName;
    public String sUDoctorAddress;

    public Sundhedskort(String cardID, int cardCprNumber, String type, String sUid, String sUAddress, String sURegion, String sUMunicipality, String sUDoctorName, String sUDoctorAddress) {
        super(cardID, cardCprNumber, type);
        this.sUid = sUid;
        this.sUAddress = sUAddress;
        this.sURegion = sURegion;
        this.sUMunicipality = sUMunicipality;
        this.sUDoctorName = sUDoctorName;
        this.sUDoctorAddress = sUDoctorAddress;
    }

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

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function
    }

    public String getsUid() {
        return sUid;
    }

    public String getsUAddress() {
        return sUAddress;
    }

    public String getsURegion() {
        return sURegion;
    }

    public String getsUMunicipality() {
        return sUMunicipality;
    }

    public String getsUDoctorName() {
        return sUDoctorName;
    }

    public String getsUDoctorAddress() {
        return sUDoctorAddress;
    }

    public Sundhedskort(){

    }

}
