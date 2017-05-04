package com.example.rasmus.p8_master;

import android.support.v7.app.AppCompatActivity;



public abstract class Card extends AppCompatActivity {

    //Variables to use on each object
    public String cardID;
    public int cardCprNumber;
    public String type;

    public Card (){

    }

    public Card(String cardID, int cardCprNumber, String type) {
        this.cardID = cardID;
        this.cardCprNumber = cardCprNumber;
        this.type = type;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setCardCprNumber(int cardCprNumber) {
        this.cardCprNumber = cardCprNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardID() {
        return cardID;
    }

    public int getCardCprNumber() {
        return cardCprNumber;
    }

    public String getType() {
        return type;
    }
}
