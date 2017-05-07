package com.example.rasmus.p8_master;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class NewCard extends Card {

    public String barcode;
    public String nameOfCard;
    //String s = getIntent().getStringExtra("EXTRA_POSITION_ID");

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_card, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //Intent intent = new Intent(this, AddNewCard.class);
        //startActivity(intent);
        int id2 = getIntent().getIntExtra("EXTRA_POSITION_ID", 0);
        id2 ++;

        if (id2 > 4) {
            //int id = Integer.valueOf(s);
            DBHelper dbHelper = new DBHelper(NewCard.this);
            dbHelper.deleteCard(id2);
            //The key argument here must match that used in the other activity
        }




        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String getBarcode() {
        return barcode;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }
}
