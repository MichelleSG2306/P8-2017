package com.example.rasmus.p8_master;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Rejsekort extends AppCompatActivity {

    //Variables to use as column names
    public static final String REJSEKORT_TABLE_NAME = "rejsekort";
    public static final String REJSEKORT_COLUMN_ID = "_id";
    public static final String REJSEKORT_COLUMN_CARDNUMBER = "card_number";
    public static final String REJSEKORT_COLUMN_AMOUNT = "amount";

    //Variables to use on each object
    public static String table_name = "";
    public static String id = "";
    public static String cardNumber = "";
    public static String amount = "";

    public Rejsekort(String table_name, String id, String cardNumber, String amount){
        this.table_name = table_name;
        this.id = id;
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejsekort);

        DBHelper dbHelper = new DBHelper(this);

        final Cursor insertCardNumber = dbHelper.getPerson(0, REJSEKORT_TABLE_NAME, REJSEKORT_COLUMN_ID);
        insertCardNumber.moveToFirst();
        String name = insertCardNumber.getString(insertCardNumber.getColumnIndex(REJSEKORT_COLUMN_CARDNUMBER));
        TextView text = (TextView) findViewById(R.id.card_number);
        text.setText(name);
    }

    //Get methods to table name and column names
    public String getRejsekortTableName(){
        return REJSEKORT_TABLE_NAME;
    }

    public String getRejsekortColumnId(){
        return REJSEKORT_COLUMN_ID;
    }

    public String getRejsekortColumnCardnumber(){
        return REJSEKORT_COLUMN_CARDNUMBER;
    }

    public String getRejsekortColumnAmount(){
        return REJSEKORT_COLUMN_AMOUNT;
    }

    //get methods to the attributes of the object

    public String getRejsekortId(){
        return id;
    }

    public String getRejsekortCardnumber(){
        return cardNumber;
    }

    public String getRejsekortAmount(){
        return amount;
    }

}
