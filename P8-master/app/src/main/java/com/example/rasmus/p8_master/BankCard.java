package com.example.rasmus.p8_master;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class BankCard extends Card {

    public String bCCardNumber;
    public String bCAccountNumber;
    public String bCRegNumber;
    public String bCExpirationDate;
    public String bCSecurityNumber;
    public int bCAmount;
    SQLiteDatabase db;

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

        DBHelper dbHelper = new DBHelper(BankCard.this);
        db = dbHelper.getReadableDatabase();
        Cursor name = db.rawQuery("Select last_name, first_name from users",null);

        name.moveToFirst();
        String firstName = name.getString(1);
        String lastName = name.getString(0);
        String fullName = firstName + " " + lastName;
        TextView text = (TextView) findViewById(R.id.fullName);
        text.append(" " + fullName);

        Cursor cardNumber = db.rawQuery("Select card_no from bank_card", null);
        cardNumber.moveToFirst();
        String cardNumber2 = cardNumber.getString(0);
        TextView textCardNumber = (TextView) findViewById(R.id.cardNumber);
        textCardNumber.append(" " + cardNumber2);

        Cursor accountNumber = db.rawQuery("Select account_no from bank_card", null);
        accountNumber.moveToFirst();
        String amount2 = accountNumber.getString(0);
        TextView textAmount = (TextView) findViewById(R.id.accountNumber);
        textAmount.append(" " + amount2);

        Cursor regNumber = db.rawQuery("Select reg_no from bank_card", null);
        regNumber.moveToFirst();
        String regNumber2 = regNumber.getString(0);
        TextView textRegNumber = (TextView) findViewById(R.id.regNumber);
        textRegNumber.append(" " + regNumber2);

        Cursor expDate = db.rawQuery("Select expiration_date from bank_card", null);
        expDate.moveToFirst();
        String expDate2 = expDate.getString(0);
        TextView textExpDate = (TextView) findViewById(R.id.expDate);
        textExpDate.append(" " + expDate2);

        Cursor secNumber = db.rawQuery("Select security_no from bank_card", null);
        secNumber.moveToFirst();
        String secNumber2 = secNumber.getString(0);
        TextView textSecNumber = (TextView) findViewById(R.id.secNumber);
        textSecNumber.append(" " + secNumber2);

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
