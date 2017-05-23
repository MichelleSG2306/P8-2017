package com.example.rasmus.p8_master;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

public class DriversLicence extends Card {

    public String dLCardNumber;
    public String dLDateOfBirth;
    public String dLCountryOfBirth;
    public String dLissuedDate;
    public String dLExpirationDate;
    public String dLIssuedBy;
    public String dLSignature;
    public String dLCategory;
    public String dLCategoryIssueDate;
    public String dLCategoryExpirationDate;
    public String dLlimitation;
    int driversLiceneImageF;
    int driversLicenceImageB;
    SQLiteDatabase db;

    public DriversLicence(){

    }

    public DriversLicence(String cardID, String type, int frontPhoto, int backPhoto, String dLCardNumber, String dLDateOfBirth, String dLCountryOfBirth, String dLissuedDate, String dLExpirationDate, String dLIssuedBy, String dLSignature, String dLCategory, String dLCategoryIssueDate, String dLCategoryExpirationDate, String dLlimitation) {
        super(cardID, type, frontPhoto, backPhoto);
        this.dLCardNumber = dLCardNumber;
        this.dLDateOfBirth = dLDateOfBirth;
        this.dLCountryOfBirth = dLCountryOfBirth;
        this.dLissuedDate = dLissuedDate;
        this.dLExpirationDate = dLExpirationDate;
        this.dLIssuedBy = dLIssuedBy;
        this.dLSignature = dLSignature;
        this.dLCategory = dLCategory;
        this.dLCategoryIssueDate = dLCategoryIssueDate;
        this.dLCategoryExpirationDate = dLCategoryExpirationDate;
        this.dLlimitation = dLlimitation;
        this.driversLiceneImageF = frontPhoto;
        this.driversLicenceImageB = backPhoto;
    }
    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drivers_lisence);
        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.driverslicence_f, R.drawable.driverslicence_b});
        viewPager.setAdapter(swipeAdapter);

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function

        DBHelper dbHelper = new DBHelper(DriversLicence.this);
        db = dbHelper.getReadableDatabase();

        Cursor name = db.rawQuery("Select last_name, first_name from users",null);
        name.moveToFirst();
        String firstName = name.getString(1);
        String lastName = name.getString(0);
        TextView text = (TextView) findViewById(R.id.textFirstName);
        text.append(" " + firstName);
        TextView textLastName = (TextView) findViewById(R.id.textLastName);
        textLastName.append(" " + lastName);

        Cursor CPR = db.rawQuery("Select cpr from users", null);
        CPR.moveToFirst();
        String CPR2 = CPR.getString(0);
        TextView textCPR = (TextView) findViewById(R.id.textCPR);
        textCPR.append(" " + CPR2);

        Cursor dateOfBirth = db.rawQuery("Select date_of_birth from drivers_licence", null);
        dateOfBirth.moveToFirst();
        String dateOfBirth2 = dateOfBirth.getString(0);
        TextView textDateOfBirth = (TextView) findViewById(R.id.textDateOfBirth);
        textDateOfBirth.append(" " + dateOfBirth2);

        Cursor countryOfBirth = db.rawQuery("Select country_of_birth from drivers_licence", null);
        countryOfBirth.moveToFirst();
        String countryOfBirth2 = countryOfBirth.getString(0);
        TextView textCountryOfBirth = (TextView) findViewById(R.id.textCountry);
        textCountryOfBirth.append(" " + countryOfBirth2);

        Cursor issueDate = db.rawQuery("Select issue_date from drivers_licence", null);
        issueDate.moveToFirst();
        String issueDate2 = issueDate.getString(0);
        TextView textIssueDate = (TextView) findViewById(R.id.textIssueDate);
        textIssueDate.append(" " + issueDate2);

        Cursor expirationDate = db.rawQuery("Select expiriry_date from drivers_licence", null);
        expirationDate.moveToFirst();
        String expirationDate2 = expirationDate.getString(0);
        TextView textExpirationDate = (TextView) findViewById(R.id.textExpirationDate);
        textExpirationDate.append(" " + expirationDate2);

        Cursor category = db.rawQuery("Select categories_of_licenced_vehicles from drivers_licence", null);
        category.moveToFirst();
        String category2 = category.getString(0);
        TextView textCategory = (TextView) findViewById(R.id.textCategory);
        textCategory.append(" " + category2);

        Cursor licenceDate = db.rawQuery("Select licence_date_of_category from drivers_licence", null);
        licenceDate.moveToFirst();
        String licenceDate2 = licenceDate.getString(0);
        TextView textLicenceDate = (TextView) findViewById(R.id.textLicenceNumber);
        textLicenceDate.append(" " + licenceDate2);

        Cursor issuedBy = db.rawQuery("Select issued_by from drivers_licence", null);
        issuedBy.moveToFirst();
        String issuedBy2 = issuedBy.getString(0);
        TextView textIssuedBy = (TextView) findViewById(R.id.textIssuedBy);
        textIssuedBy.append(" " + issuedBy2);
    }

    public String getdLCardNumber() {
        return dLCardNumber;
    }

    public String getdLDateOfBirth() {
        return dLDateOfBirth;
    }

    public String getdLCountryOfBirth() {
        return dLCountryOfBirth;
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

    public int getDriversLiceneImageF() {
        return driversLiceneImageF;
    }

    public int getDriversLicenceImageB() {
        return driversLicenceImageB;
    }

}


