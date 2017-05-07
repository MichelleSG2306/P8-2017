package com.example.rasmus.p8_master;

import android.content.ContentValues;
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

    public static final String USER_TABLE_NAME = "users";
    public static final String USER_COLUMN_CPR = "cpr";
    public static final String USER_COLUMN_LAST_NAME = "last_name";
    public static final String USER_COLUMNS_FIRST_NAME = "first_name";

    public static final String CARD_TABLE_NAME = "cards";
    public static final String CARD_COLUMN_CARD_ID = "card_id";
    public static final String CARD_COLUMN_CPR = "cpr";
    public static final String CARD_COLUMN_CARD_TYPE = "card_type";
    public static final String CARD_COLUMN_FRONT_PHOTO = "front_photo";
    public static final String CARD_COLUMN_BACK_PHOTO = "back_photo";

    public static final String RK_TABLE_NAME = "rejsekort";
    public static final String RK_COLUMN_CARD_NO = "card_no";
    public static final String RK_COLUMN_AMOUNT = "amount";


    //Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    User user = new User("170492-1802", "Hans", "Hansen");
    String userCpr = user.getCPR();
    String userFirstName = user.getFirstName();
    String userLastName = user.getLastName();

    @Override
    public void onCreate(SQLiteDatabase db) {

//____________________________________________________________________________________//


        db.execSQL("CREATE TABLE " + USER_TABLE_NAME + "(" +
                USER_COLUMN_CPR + " VARCHAR(11) NOT NULL PRIMARY KEY, " +
                USER_COLUMN_LAST_NAME + " VARCHAR(30) NOT NULL, " +
                USER_COLUMNS_FIRST_NAME + " VARCHAR(20) NOT NULL);"
        );


        db.execSQL("INSERT INTO " + USER_TABLE_NAME + " VALUES ('" + userCpr + "','" + userLastName + "','" + userFirstName + "');"
        );

//____________________________________________________________________________________//


        Rejsekort objRejsekort = new Rejsekort("", "Rejsekort", R.drawable.rejsekort_f, R.drawable.rejsekort_b, "", "123456789", 123);
        String rejsekortCardType = objRejsekort.getType();
        int rejsekortImageF = objRejsekort.getFrontPhoto();
        int rejsekortImageB = objRejsekort.getBackPhoto();

        Card objBankCard = new BankCard("", "Bank Card", R.drawable.bankcard_f, R.drawable.bankcard_b, "123456789", "123456", "1234", "24/07", "789", 400);
        String bankCardType = objBankCard.getType();
        int bankCardImageF = objBankCard.getFrontPhoto();
        int bankCardImageB = objBankCard.getBackPhoto();

        Card objDriversLicence = new DriversLicence("", "Drivers Licence", R.drawable.driverslicence_f, R.drawable.driverslicence_b, "787947984", "1992-04-12", "2010-04-12", "2070-04-12", "Rigspolitichefen", "", "B", "2010-04-12", "2070-04-12", "");
        String driversLicenceType = objDriversLicence.getType();
        int driversLiceneImageF = objDriversLicence.getFrontPhoto();
        int driversLicenceImageB = objDriversLicence.getBackPhoto();

        Card objSundhedskort = new Sundhedskort("", "Sundhedskort", R.drawable.sundhedskort_f, R.drawable.sundhedskort_b, "Aalborg", "9000", "Løkkegade", "12", "Nordjylland", "Aalborg Kommune", "Jesper", "Larsen", "Aalborg", "9000", "Haraldsvej", "17");
        String sundhedskortType = objSundhedskort.getType();
        int sundhedskortImageF = objSundhedskort.getFrontPhoto();
        int sundhedskortImageB = objSundhedskort.getBackPhoto();

        Card objUngdomskort = new Ungdomskort("", "Ungdomskort", R.drawable.ungdomskort_f, R.drawable.ungdomskort_b, "1234567", "Randers - Aalborg", "2016-09-09", "2017-09-09", "1992-04-12");
        String ungdomskortType = objUngdomskort.getType();
        int ungdomskortImageF = objUngdomskort.getFrontPhoto();
        int ungdomskortImageB = objUngdomskort.getBackPhoto();


        db.execSQL("CREATE TABLE " + CARD_TABLE_NAME + "(" +
                CARD_COLUMN_CARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CARD_COLUMN_CPR + " VARCHAR(11) NOT NULL," +
                CARD_COLUMN_CARD_TYPE + " VARCHAR(30), " +
                CARD_COLUMN_FRONT_PHOTO + " INT, " +
                CARD_COLUMN_BACK_PHOTO + " INT," +
                "FOREIGN KEY (" + CARD_COLUMN_CPR + ") REFERENCES " + USER_TABLE_NAME + "(" + USER_COLUMN_CPR + ")" +
                ");");

        db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" + CARD_COLUMN_CPR + "," + CARD_COLUMN_CARD_TYPE + "," + CARD_COLUMN_FRONT_PHOTO + "," + CARD_COLUMN_BACK_PHOTO + ")" +
                " VALUES('" + userCpr + "','" + rejsekortCardType + "'," + rejsekortImageF + "," + rejsekortImageB + ")," +
                "('" + userCpr + "','" + bankCardType + "'," + bankCardImageF + "," + bankCardImageB + ")," +
                "('" + userCpr + "','" + driversLicenceType + "'," + driversLiceneImageF + "," + driversLicenceImageB + ")," +
                "('" + userCpr + "','" + sundhedskortType + "'," + sundhedskortImageF + "," + sundhedskortImageB + ")," +
                "('" + userCpr + "','" + ungdomskortType + "'," + ungdomskortImageF + "," + ungdomskortImageB + ");"
        );


//____________________________________________________________________________________//


        String rejsekortCardNumber = objRejsekort.getCardNumber();
        Cursor cardIdFk = db.rawQuery("select " + CARD_COLUMN_CARD_ID + " from " + CARD_TABLE_NAME + " where " + CARD_COLUMN_CARD_TYPE + " = '" + rejsekortCardType + "'", null);
        cardIdFk.moveToFirst();
        String rejsekortCardIdFk = cardIdFk.getString(0);
        String rejsekortAmount = Integer.toString(objRejsekort.getAmount());

        db.execSQL(
                "CREATE TABLE " + RK_TABLE_NAME + "(" +
                        RK_COLUMN_CARD_NO + " VARCHAR(30) NOT NULL PRIMARY KEY, " +
                        CARD_COLUMN_CARD_ID + " INT NOT NULL, " +
                        RK_COLUMN_AMOUNT + " INT NOT NULL," +
                        "FOREIGN KEY (" + CARD_COLUMN_CARD_ID + ") REFERENCES " + CARD_TABLE_NAME + " (" + CARD_COLUMN_CARD_ID + ")" +
                        ");"
        );

        db.execSQL("INSERT INTO " + RK_TABLE_NAME + " VALUES(" + rejsekortCardNumber + "," + rejsekortCardIdFk + "," + rejsekortAmount + ");"
        );
//_____________________________________________________________________________________//



        //BankCard bankCardObj = new BankCard();
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
        public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion){
            //db.execSQL("DROP TABLE IF EXISTS rejsekort;"); //+ PERSON_TABLE_NAME);
            //onCreate(db);
        }

        public void insertCard (String cardNameInput, int blueOrgreen){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(CARD_COLUMN_CPR, "'"+ userCpr +"'" );
            contentValues.put(CARD_COLUMN_CARD_TYPE, "'"+ cardNameInput +"'");
            contentValues.put(CARD_COLUMN_FRONT_PHOTO, blueOrgreen);
            contentValues.put(CARD_COLUMN_BACK_PHOTO, blueOrgreen);

            db.insert(CARD_TABLE_NAME, null, contentValues);
        }

    public void deleteCard(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+CARD_TABLE_NAME+" where " + CARD_COLUMN_CARD_ID + " = "+id);
        MainActivity main = new MainActivity();
        main.updateAfterDelete();
    }
    }


