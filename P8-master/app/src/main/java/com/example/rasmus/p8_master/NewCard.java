package com.example.rasmus.p8_master;

import android.os.Bundle;

public class NewCard extends Card {

    public String nCCardNumber;
    public String nCAttribute;
    public String nCValue;

    public NewCard(){

    }

    public NewCard(String cardID, int cardCprNumber, String type, String nCCardNumber, String nCAttribute, String nCValue) {
        super(cardID, cardCprNumber, type);
        this.nCCardNumber = nCCardNumber;
        this.nCAttribute = nCAttribute;
        this.nCValue = nCValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);
    }

    public String getnCCardNumber() {
        return nCCardNumber;
    }

    public void setnCCardNumber(String nCCardNumber) {
        this.nCCardNumber = nCCardNumber;
    }

    public String getnCAttribute() {
        return nCAttribute;
    }

    public void setnCAttribute(String nCAttribute) {
        this.nCAttribute = nCAttribute;
    }

    public String getnCValue() {
        return nCValue;
    }

    public void setnCValue(String nCValue) {
        this.nCValue = nCValue;
    }
}
