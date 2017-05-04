package com.example.rasmus.p8_master;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ungdomskort extends Card {

    public String uKCardNumber;
    public String uKtravelZone;
    public String uKIssuedDate;
    public String uKExpirationDate;
    public String uKDateOfBirth;
    SQLiteDatabase db;

    public Ungdomskort() {

    }

    public Ungdomskort(String uKCardNumber, String uKtravelZone, String uKIssuedDate, String uKExpirationDate, String uKDateOfBirth) {
        this.uKCardNumber = uKCardNumber;
        this.uKtravelZone = uKtravelZone;
        this.uKIssuedDate = uKIssuedDate;
        this.uKExpirationDate = uKExpirationDate;
        this.uKDateOfBirth = uKDateOfBirth;
    }

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ungdomskort);
        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.ungdomskort_f, R.drawable.ungdomskort_b});
        viewPager.setAdapter(swipeAdapter);

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function

        DBHelper dbHelper = new DBHelper(Ungdomskort.this);
        db = dbHelper.getReadableDatabase();

        Cursor name = db.rawQuery("Select last_name, first_name from users",null);
        name.moveToFirst();
        String firstName = name.getString(1);
        String lastName = name.getString(0);
        String fullName = firstName + " " + lastName;
        TextView text = (TextView) findViewById(R.id.textName);
        text.append(" " + fullName);

        Cursor travelZone = db.rawQuery("Select travelzone from ungdomskort",null);
        travelZone.moveToFirst();
        String travelZone2 = travelZone.getString(0);
        TextView textTravelZone = (TextView) findViewById(R.id.textTravelZones);
        textTravelZone.append(" " + travelZone2);

        Cursor validationPeriod = db.rawQuery("Select issue_date, expiration_date from ungdomskort", null);
        validationPeriod.moveToFirst();
        String issuePeriod = validationPeriod.getString(0);
        String expirationPeriod = validationPeriod.getString(1);
        String validationPeriod2 = issuePeriod + " - " + expirationPeriod;
        TextView textValidationPeriod = (TextView) findViewById(R.id.textValidationPeriod);
        textValidationPeriod.append(" " + validationPeriod2);

        Cursor dateOfBirth = db.rawQuery("Select date_of_birth from ungdomskort",null);
        dateOfBirth.moveToFirst();
        String dateOfBirth2 = dateOfBirth.getString(0);
        TextView textDateOfBirth = (TextView) findViewById(R.id.textDateOfBirth);
        textDateOfBirth.append(" " + dateOfBirth2);

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
