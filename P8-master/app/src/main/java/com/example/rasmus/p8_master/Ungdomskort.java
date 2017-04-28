package com.example.rasmus.p8_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ungdomskort extends Card {

    public String uKCardNumber;
    public String uKtravelZone;
    public String uKIssuedDate;
    public String uKExpirationDate;
    public String uKDateOfBirth;

    public Ungdomskort() {

    }

    public Ungdomskort(String uKCardNumber, String uKtravelZone, String uKIssuedDate, String uKExpirationDate, String uKDateOfBirth) {
        this.uKCardNumber = uKCardNumber;
        this.uKtravelZone = uKtravelZone;
        this.uKIssuedDate = uKIssuedDate;
        this.uKExpirationDate = uKExpirationDate;
        this.uKDateOfBirth = uKDateOfBirth;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ungdomskort);
    }

    public String getuKCardNumber() {
        return uKCardNumber;
    }

    public String getuKtravelZone() {
        return uKtravelZone;
    }

    public String getuKIssuedDate() {
        return uKIssuedDate;
    }

    public String getuKExpirationDate() {
        return uKExpirationDate;
    }

    public String getuKDateOfBirth() {
        return uKDateOfBirth;
    }
}
