package com.example.rasmus.p8_master;

import android.os.Bundle;

public class NewCard extends Card {

    public String barcode;
    public String nameOfCard;

    public NewCard(){

    }

    public NewCard(String cardID, int cardCprNumber, String type, String barcode, String nameOfCard) {
        super(cardID, cardCprNumber, type);
        this.barcode = barcode;
        this.nameOfCard = nameOfCard;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
    }

    public String getBarcode() {
        return barcode;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }
}
