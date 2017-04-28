package com.example.rasmus.p8_master;

import android.os.Bundle;

public class BankCard extends Card {

    public String bCCardNumber;
    public String bCAccountNumber;
    public String bCRegNumber;
    public String bCExpirationDate;
    public String bCSecurityNumber;
    public int bCAmount;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card);
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
