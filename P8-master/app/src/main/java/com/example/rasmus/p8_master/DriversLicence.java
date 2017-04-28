package com.example.rasmus.p8_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DriversLicence extends Card {

    public String dLCardNumber;
    public String dLDateOfBirth;
    public String dLissuedDate;
    public String dLExpirationDate;
    public String dLIssuedBy;
    public String dLSignature;
    public String dLCategory;
    public String dLCategoryIssueDate;
    public String dLCategoryExpirationDate;
    public String dLlimitation;

    public DriversLicence(){

    }

    public DriversLicence(String dLCardNumber, String dLDateOfBirth, String dLissuedDate, String dLExpirationDate, String dLIssuedBy, String dLSignature, String dLCategory, String dLCategoryIssueDate, String dLCategoryExpirationDate, String dLlimitation) {

        this.dLCardNumber = dLCardNumber;
        this.dLDateOfBirth = dLDateOfBirth;
        this.dLissuedDate = dLissuedDate;
        this.dLExpirationDate = dLExpirationDate;
        this.dLIssuedBy = dLIssuedBy;
        this.dLSignature = dLSignature;
        this.dLCategory = dLCategory;
        this.dLCategoryIssueDate = dLCategoryIssueDate;
        this.dLCategoryExpirationDate = dLCategoryExpirationDate;
        this.dLlimitation = dLlimitation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_lisence);
    }

    public String getdLCardNumber() {
        return dLCardNumber;
    }

    public String getdLDateOfBirth() {
        return dLDateOfBirth;
    }

    public String getdLissuedDate() {
        return dLissuedDate;
    }

    public String getdLExpirationDate() {
        return dLExpirationDate;
    }

    public String getdLIssuedBy() {
        return dLIssuedBy;
    }

    public String getdLSignature() {
        return dLSignature;
    }

    public String getdLCategory() {
        return dLCategory;
    }

    public String getdLCategoryIssueDate() {
        return dLCategoryIssueDate;
    }

    public String getdLCategoryExpirationDate() {
        return dLCategoryExpirationDate;
    }

    public String getdLlimitation() {
        return dLlimitation;
    }

}


