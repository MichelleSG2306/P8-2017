package com.example.rasmus.p8_master;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rejsekort extends Card {



    //Variables to use on each object
    public static String id;
    public static String cardNumber;
    public static String amount;

    //Constructors
    public Rejsekort(){
    }

    public Rejsekort(String id, String cardNumber, String amount){
        this.id = id;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejsekort);

    }

    //get methods
    public String getRejsekortId(){
        return id;
    }

    public String getRejsekortCardnumber(){
        return cardNumber;
    }

    public String getRejsekortAmount(){
        return amount;
    }

}
