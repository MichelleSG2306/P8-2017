package com.example.rasmus.p8_master;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Sundhedskort extends Card {

    //Variables to use on each object
    public String sUid;
    public String sUAddress;
    public String sURegion;
    public String sUMunicipality;
    public String sUDoctorName;
    public String sUDoctorAddress;
    SQLiteDatabase db;

    public Sundhedskort(String cardID, int cardCprNumber, String type, String sUid, String sUAddress, String sURegion, String sUMunicipality, String sUDoctorName, String sUDoctorAddress) {
        super(cardID, cardCprNumber, type);
        this.sUid = sUid;
        this.sUAddress = sUAddress;
        this.sURegion = sURegion;
        this.sUMunicipality = sUMunicipality;
        this.sUDoctorName = sUDoctorName;
        this.sUDoctorAddress = sUDoctorAddress;
    }

    //Swipe Function
    SwipeAdapter swipeAdapter;
    ViewPager viewPager;
    //Swipe Function

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sundhedskort);
        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.sundhedskort_f, R.drawable.sundhedskort_b});
        viewPager.setAdapter(swipeAdapter);

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
        //dots
        //Swipe Function

        DBHelper dbHelper = new DBHelper(Sundhedskort.this);
        db = dbHelper.getReadableDatabase();
        Cursor name = db.rawQuery("Select last_name, first_name from users",null);

        name.moveToFirst();
        String firstName = name.getString(1);
        String lastName = name.getString(0);
        String fullName = firstName + " " + lastName;
        TextView text = (TextView) findViewById(R.id.textFullName);
        text.append(" " + fullName);

        Cursor CPR = db.rawQuery("Select cpr from users", null);
        CPR.moveToFirst();
        String CPR2 = CPR.getString(0);
        TextView textCardNumber = (TextView) findViewById(R.id.textCPR);
        textCardNumber.append(" " + CPR2);

        Cursor validFrom = db.rawQuery("Select valid_from from sundhedskort", null);
        validFrom.moveToFirst();
        String validFrom2 = validFrom.getString(0);
        TextView textValidFrom = (TextView) findViewById(R.id.textValidFrom);
        textValidFrom.append(" " + validFrom2);

        Cursor address = db.rawQuery("Select zip_code, city, street_name, street_number from sundhedskort", null);
        address.moveToFirst();
        String zip = address.getString(0);
        String city = address.getString(1);
        String street = address.getString(2);
        String number = address.getString(3);
        TextView textAddress = (TextView) findViewById(R.id.textAddress);
        textAddress.append(" " + zip + " " + city + ", " + street + " " + number);

        Cursor region = db.rawQuery("Select region from sundhedskort", null);
        region.moveToFirst();
        String region2 = region.getString(0);
        TextView textRegion = (TextView) findViewById(R.id.textRegion);
        textRegion.append(" " + region2);

        Cursor municipality = db.rawQuery("Select municipality from sundhedskort", null);
        municipality.moveToFirst();
        String municipality2 = municipality.getString(0);
        TextView textMunicipality = (TextView) findViewById(R.id.textMunicipality);
        textMunicipality.append(" " + municipality2);

        Cursor doctorName = db.rawQuery("Select doctor_first_name, doctor_last_name from sundhedskort",null);
        doctorName.moveToFirst();
        String doctorFirstName = doctorName.getString(0);
        String doctorLastName = doctorName.getString(1);
        String doctorFullName = doctorFirstName + " " + doctorLastName;
        TextView textDoctor = (TextView) findViewById(R.id.textDoctor);
        textDoctor.append(" " + doctorFullName);

        Cursor doctorAddress = db.rawQuery("Select doctor_zip, doctor_city, doctor_street_name, doctor_street_number from sundhedskort", null);
        doctorAddress.moveToFirst();
        String doctor_zip = doctorAddress.getString(0);
        String doctor_city = doctorAddress.getString(1);
        String doctor_street = doctorAddress.getString(2);
        String doctor_number = doctorAddress.getString(3);
        TextView textDoctorAddress = (TextView) findViewById(R.id.textDoctorsAddress);
        textDoctorAddress.append(" " + doctor_zip + " " + doctor_city + ", " + doctor_street + " " + doctor_number);

        Cursor doctorPhone = db.rawQuery("Select doctor_phone from sundhedskort", null);
        doctorPhone.moveToFirst();
        String doctorPhone2 = doctorPhone.getString(0);
        TextView textDoctorPhone = (TextView) findViewById(R.id.textDoctorsPhone);
        textDoctorPhone.append(" " + doctorPhone2);



    }

    public String getsUid() {
        return sUid;
    }

    public String getsUAddress() {
        return sUAddress;
    }

    public String getsURegion() {
        return sURegion;
    }

    public String getsUMunicipality() {
        return sUMunicipality;
    }

    public String getsUDoctorName() {
        return sUDoctorName;
    }

    public String getsUDoctorAddress() {
        return sUDoctorAddress;
    }

    public Sundhedskort(){

    }

}
