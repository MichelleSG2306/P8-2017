package com.example.rasmus.p8_master;

import android.support.v7.app.AppCompatActivity;



public abstract class Card extends AppCompatActivity {

    //Variables to use on each object
    public String cardID;
    public String type;
    public int frontPhoto;
    public int backPhoto;

    public Card (){

    }

    public Card(String cardID, String type, int frontPhoto, int backPhoto) {
        this.cardID = cardID;
        this.type = type;
        this.frontPhoto = frontPhoto;
        this.backPhoto = backPhoto;
    }



    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardID() {
        return cardID;
    }

    public String getType() {return type;}

    public int getFrontPhoto() {
        return frontPhoto;
    }

    public int getBackPhoto() {
        return backPhoto;
    }

}
