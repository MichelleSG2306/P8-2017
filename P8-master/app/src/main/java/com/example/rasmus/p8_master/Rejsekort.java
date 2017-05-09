package com.example.rasmus.p8_master;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class Rejsekort extends Card {



    //Variables to use on each object
    public String id;
    public String cardNumber;
    public int amount;
    int rejsekortImageF;
    int rejsekortImageB;
    SQLiteDatabase db;


    //Constructors
    public Rejsekort(){
    }

    public Rejsekort(String cardID, String type, int frontPhoto, int backPhoto, String id, String cardNumber, int amount) {
        super(cardID, type, frontPhoto, backPhoto);
        this.id = id;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.rejsekortImageF = frontPhoto;
        this.rejsekortImageB = backPhoto;
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

            DBHelper dbHelper = new DBHelper(Rejsekort.this);
            db = dbHelper.getReadableDatabase();
            Cursor name = db.rawQuery("Select last_name, first_name from users",null);

            name.moveToFirst();
            String firstName = name.getString(1);
            String lastName = name.getString(0);
            String fullName = firstName + " " + lastName;
            TextView text = (TextView) findViewById(R.id.textView);
            text.append(" " + fullName);

            Cursor cardNumber = db.rawQuery("Select card_no from rejsekort", null);
            cardNumber.moveToFirst();
            String cardNumber2 = cardNumber.getString(0);
            TextView textCardNumber = (TextView) findViewById(R.id.card_number);
            textCardNumber.append(" " + cardNumber2);

            Cursor amount = db.rawQuery("Select amount from rejsekort", null);
            amount.moveToFirst();
            String amount2 = amount.getString(0);
            TextView textAmount = (TextView) findViewById(R.id.amount);
            textAmount.append(" " + amount2 + ",-");

    }

    //get methods

    public String getId() {
        return id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getAmount() {
        return amount;
    }

    public int getRejsekortImageF() {
        return rejsekortImageF;
    }

    public int getRejsekortImageB() {
        return rejsekortImageB;
    }
}
