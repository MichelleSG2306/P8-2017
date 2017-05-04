package com.example.rasmus.p8_master;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rasmus on 25-04-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "P8.db";
    private static final int DATABASE_VERSION = 1;

    //Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
   public void onCreate(SQLiteDatabase db) {

//____________________________________________________________________________________//
        User user = new User("1704921802", "Hans", "Hansen");
        String userCpr = user.getCPR();
        String userFirstName = user.getFirstName();
        String userLastName = user.getLastName();

        db.execSQL("CREATE TABLE users\n" +
                "(\n" +
                "cpr VARCHAR(11) NOT NULL PRIMARY KEY,\n" +
                "last_name VARCHAR(30) NOT NULL, \n" +
                "first_name VARCHAR(20) NOT NULL\n" +
                ");"
        );

       db.execSQL("INSERT INTO users (cpr , last_name , first_name)  VALUES ('187483-1111','Hansen','Hans' );"
       );
        //For some reason this doesn't work!!!
        //db.execSQL("INSERT INTO users (cpr , last_name, first_name) VALUES(" + userCpr + "," + userLastName + "," + userFirstName + ");"
        //);


//____________________________________________________________________________________//


        db.execSQL("CREATE TABLE cards \n" +
                "(\n" +
                "card_id INT PRIMARY KEY, \n" +
                "cpr VARCHAR(11) NOT NULL,\n" +
                "card_type VARCHAR(30), \n" +
                "front_photo BLOB, back_photo BLOB,\n" +
                "FOREIGN KEY (cpr) REFERENCES users(cpr)\n" +
                ")\n" +
                ";\n");

        db.execSQL("INSERT INTO cards (card_id , cpr, card_type) VALUES(1, '170492-1802','Rejsekort');"
        );
        db.execSQL("INSERT INTO cards (card_id , cpr, card_type) VALUES(2, '170492-1802','Bank Card');"
        );
        db.execSQL("INSERT INTO cards (card_id , cpr, card_type) VALUES(3, '170492-1802','Drivers Licence');"
        );
        db.execSQL("INSERT INTO cards (card_id , cpr, card_type) VALUES(4, '170492-1802','Sundhedskort');"
        );
        db.execSQL("INSERT INTO cards (card_id , cpr, card_type) VALUES(5, '170492-1802','Ungdomskort');"
        );
//____________________________________________________________________________________//


           Rejsekort rejsekort = new Rejsekort("1", "123456789", 123, db);
           String rejsekortId = rejsekort.getRejsekortId();
           String rejsekortCardnumber = rejsekort.getRejsekortCardnumber();
           String rejsekortAmount = Integer.toString(rejsekort.getRejsekortAmount());

        db.execSQL(
                "CREATE TABLE rejsekort \n" +
                        "(\n" +
                        "card_no VARCHAR(30) NOT NULL PRIMARY KEY, \n" +
                        "card_id INT NOT NULL, \n" +
                        "amount INT NOT NULL,\n" +
                        "FOREIGN KEY (card_id) REFERENCES cards (card_id)\n" +
                        ")\n" +
                        ";\n"
        );

        db.execSQL("INSERT INTO rejsekort (card_no , card_id, amount) VALUES(" + rejsekortCardnumber + "," + rejsekortId + "," + rejsekortAmount + ");"
        );
//_____________________________________________________________________________________//

        BankCard bankCardObj = new BankCard();
        db.execSQL("CREATE TABLE bank_card \n" +
                "(card_no VARCHAR(30) NOT NULL PRIMARY KEY, \n" +
                "card_id INT, \n" +
                "reg_no INT, \n" +
                "account_no VARCHAR(30), \n" +
                "expiration_date DATE, \n" +
                "security_no VARCHAR (4), \n" +
                "FOREIGN KEY (card_id) REFERENCES cards (card_id) \n" +
                ")\n" +
                ";\n");


        db.execSQL("INSERT INTO bank_card VALUES('123456789', 2, 1734, '123456', '2017-7-04', '123');"
       );

//_______________________________________________________________________________________//

        db.execSQL("CREATE TABLE sundhedskort \n" +
                "(\n" +
                "id INT PRIMARY KEY, \n" +
                "card_id INT NOT NULL, \n" +
                "municipality VARCHAR (30), \n" +
                "city VARCHAR(20), \n" +
                "zip_code INT, \n" +
                "street_name VARCHAR(20), \n" +
                "street_number VARCHAR(10), \n" +
                "region VARCHAR (10), \n" +
                "doctor_first_name VARCHAR(40), \n" +
                "doctor_last_name VARCHAR(40), \n" +
                "doctor_city VARCHAR(40), \n" +
                "doctor_zip INT, \n" +
                "doctor_street_name VARCHAR(40), \n" +
                "doctor_street_number VARCHAR(40), \n" +
                "doctor_phone INT, \n" +
                "valid_from DATE, \n" +
                "FOREIGN KEY (card_id) REFERENCES cards (card_id)\n" +
                ")\n" +
                ";"
        );

        db.execSQL("INSERT INTO sundhedskort VALUES(1, 4, 'Aalborg Kommune', 'Aalborg', 9000, 'Løkkegade', '12', 'Nordjylland', 'Lægerne', 'Budolfi Plads', 'Aalborg', 9000, 'Blåbærvej', '17', 98124466, '2014-08-01'  );"
        );


        db.execSQL("CREATE TABLE drivers_licence \n" +
                "(\n" +
                "card_no INT NOT NULL PRIMARY KEY, \n" +
                "card_id INT, \n" +
                "date_of_birth DATE, \n" +
                "country_of_birth VARCHAR(30), \n" +
                "issue_date DATE, \n" +
                "expiriry_date DATE,\n" +
                "issued_by VARCHAR(20), \n" +
                "categories_of_licenced_vehicles VARCHAR(20), \n" +
                "licence_date_of_category DATE, \n" +
                "limitations VARCHAR (50), \n" +
                "FOREIGN KEY (card_id) REFERENCES cards (card_id)\n" +
                ")\n" +
                ";\n");

        db.execSQL("INSERT INTO drivers_licence VALUES(123456789, 3, '1992-04-12', 'Danmark', '2010-04-12', '2070-04-12', 'Rigspolitichefen','B', '1992-04-12', 'NULL' )");


        db.execSQL("CREATE TABLE ungdomskort \n" +
                "(card_no INT NOT NULL PRIMARY KEY, \n" +
                "card_id INT, \n" +
                "travelzone VARCHAR(30), \n" +
                "issue_date DATE, \n" +
                "expiration_date DATE, \n" +
                "date_of_birth DATE,\n" +
                "FOREIGN KEY (card_id) REFERENCES cards (card_id)\n" +
                ")\n" +
                ";");

        db.execSQL("INSERT INTO ungdomskort VALUES(123456789, 5, 'Randers - Aalborg', '2012-03-04', '2013-03-04', '1992-04-12' )");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS rejsekort;"); //+ PERSON_TABLE_NAME);
        //onCreate(db);
    }

}
