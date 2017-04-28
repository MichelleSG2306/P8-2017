package com.example.rasmus.p8_master;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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

    public int getRejsekortAmount(){
        return amount;
    }

}
