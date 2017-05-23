package com.example.rasmus.p8_master;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public static final String OTHER_TABLE_NAME = "othercards";
    public static final String OTHER_COLUMN_NAME = "name";
    public static final String OTHER_COLUMN_BARCODE = "barcode";

    public static final String BC_TABLE_NAME = "bank_card";
    public static final String BC_COLUMN_CARD_NO = "card_no";
    public static final String BC_COLUMN_REG_NO = "reg_no";
    public static final String BC_COLUMN_ACCOUNT_NO = "account_no";
    public static final String BC_COLUMN_EXPIRATION_DATE = "expiration_date";
    public static final String BC_COLUMN_SECURITY_NO = "security_no";
    public static final String BC_COLUMN_AMOUNT = "amount";

    public static final String SK_TABLE_NAME = "sundhedskort";
    public static final String SK_COLUMN_ID = "id";
    public static final String SK_COLUMN_MUNICIPALITY = "municipality";
    public static final String SK_COLUMN_CITY = "city";
    public static final String SK_COLUMN_ZIP_CODE = "zip_code";
    public static final String SK_COLUMN_STREET_NAME = "street_name";
    public static final String SK_COLUMN_STREET_NUMBER = "street_number";
    public static final String SK_COLUMN_REGION = "region";
    public static final String SK_COLUMN_DR_FRIST_NAME = "doctor_first_name";
    public static final String SK_COLUMN_DR_LAST_NAME = "doctor_last_name";
    public static final String SK_COLUMN_DR_CITY = "doctor_city";
    public static final String SK_COLUMN_DR_ZIP = "doctor_zip";
    public static final String SK_COLUMN_DR_STREET_NAME = "doctor_street_name";
    public static final String SK_COLUMN_DR_STREET_NUMBER = "doctor_street_number";
    public static final String SK_COLUMN_DR_PHONE = "doctor_phone";
    public static final String SK_COLUMN_VALID_FROM = "valid_from";

    /**public static final String UK_TABLE_NAME = "ugdomskort";
    public static final String UK_COLUMN_CARD_NO = "card_no";
    public static final String UK_COLUMN_TRAVEL_ZONE = "travelzone";
    public static final String UK_COLUMN_ISSUE_DATE = "issue_date";
    public static final String UK_COLUMN_EXPIRATION_DATE = "expiration_date";
    public static final String UK_COLUMN_DATE_OF_BIRTH = "date_of_birth";

    public static final String DL_TABLE_NAME = "drivers_licence";
    public static final String DL_COLUMN_CARD_NO = "card_no";
    public static final String DL_COLUMN_DATE_OF_BIRTH = "date_of_birth";
    public static final String DL_COLUMN_COUNTRY_OF_BIRTH = "country_of_birth";
    public static final String DL_COLUMN_ISSUE_DATE = "issue_date";
    public static final String DL_COLUMN_EXPIRITY_DATE = "expirity_date";
    public static final String DL_COLUMN_ISSUED_BY = "issued_by";
    public static final String DL_COLUMN_CATEGORIES_OF_LICENCED_VEHIVCLES =
    "categories_of_licenced_vehicles";
    public static final String DL_COLUMN_LICENCE_DATE_OF_CATEGORY = "licence_date_of_category";
    public static final String DL_LIMITATIONS = "limitations";*/

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


        db.execSQL("INSERT INTO " + USER_TABLE_NAME + " VALUES ('" + userCpr + "','"
                + userLastName + "','" + userFirstName + "');"
        );
//___________________________________________________________________________________//


        Rejsekort objRejsekort = new Rejsekort("", "Rejsekort", R.drawable.rejsekort_f,
                R.drawable.rejsekort_b, "", "123456789", 123);
        String rejsekortCardType = objRejsekort.getType();
        int rejsekortImageF = objRejsekort.getFrontPhoto();
        int rejsekortImageB = objRejsekort.getBackPhoto();

        BankCard objBankCard = new BankCard("", "Bank Card", R.drawable.bankcard_f,
                R.drawable.bankcard_b, "123456789", "123456", "1234", "24/07", "789", 400);
        String bankCardType = objBankCard.getType();
        int bankCardImageF = objBankCard.getFrontPhoto();
        int bankCardImageB = objBankCard.getBackPhoto();

        DriversLicence objDriversLicence = new DriversLicence("", "Drivers Licence",
                R.drawable.driverslicence_f, R.drawable.driverslicence_b, "787947984",
                "1992-04-12", "Denmark", "2010-04-12", "2070-04-12", "Rigspolitichefen", "", "B",
                "2010-04-12", "2070-04-12", "");
        String driversLicenceType = objDriversLicence.getType();
        int driversLiceneImageF = objDriversLicence.getFrontPhoto();
        int driversLicenceImageB = objDriversLicence.getBackPhoto();

        Sundhedskort objSundhedskort = new Sundhedskort("", "Sundhedskort",
                R.drawable.sundhedskort_f, R.drawable.sundhedskort_b, "1", "Aalborg", "9000",
                "Løkkegade", "12", "Nordjylland", "Aalborg Kommune", "Jesper", "Larsen", "Aalborg",
                "9000", "Haraldsvej", "17", "98124466", "2014-08-01" );
        String sundhedskortType = objSundhedskort.getType();
        int sundhedskortImageF = objSundhedskort.getFrontPhoto();
        int sundhedskortImageB = objSundhedskort.getBackPhoto();

        Ungdomskort objUngdomskort = new Ungdomskort("", "Ungdomskort", R.drawable.ungdomskort_f,
                R.drawable.ungdomskort_b, "1234567", "Randers - Aalborg", "2016-09-09",
                "2017-09-09", "1992-04-12");
        String ungdomskortType = objUngdomskort.getType();
        int ungdomskortImageF = objUngdomskort.getFrontPhoto();
        int ungdomskortImageB = objUngdomskort.getBackPhoto();

//____________________________________________________________________________________//

        db.execSQL("CREATE TABLE " + CARD_TABLE_NAME + "(" +
                CARD_COLUMN_CARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CARD_COLUMN_CPR + " VARCHAR(11) NOT NULL," +
                CARD_COLUMN_CARD_TYPE + " VARCHAR(30), " +
                CARD_COLUMN_FRONT_PHOTO + " INT, " +
                CARD_COLUMN_BACK_PHOTO + " INT," +
                "FOREIGN KEY (" + CARD_COLUMN_CPR + ") REFERENCES " + USER_TABLE_NAME
                + "(" + USER_COLUMN_CPR + ")" +
                ");");

        db.execSQL("INSERT INTO " + CARD_TABLE_NAME + " (" + CARD_COLUMN_CPR + ","
                + CARD_COLUMN_CARD_TYPE + "," + CARD_COLUMN_FRONT_PHOTO + ","
                + CARD_COLUMN_BACK_PHOTO + ")" +
                " VALUES('" + userCpr + "','" + rejsekortCardType + "'," + rejsekortImageF + ","
                + rejsekortImageB + ")," + "('" + userCpr + "','" + bankCardType + "',"
                + bankCardImageF + "," + bankCardImageB + ")," + "('" + userCpr + "','"
                + driversLicenceType + "'," + driversLiceneImageF + ","
                + driversLicenceImageB + ")," + "('" + userCpr + "','" + sundhedskortType + "',"
                + sundhedskortImageF + "," + sundhedskortImageB + ")," + "('" + userCpr + "','"
                + ungdomskortType + "'," + ungdomskortImageF + "," + ungdomskortImageB + ");"
        );
//_______________________________________________________________________________//

        db.execSQL("CREATE TABLE " + OTHER_TABLE_NAME + "(" +
                 CARD_COLUMN_CARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                 OTHER_COLUMN_NAME + " VARCHAR(30)," +
                 OTHER_COLUMN_BARCODE + " VARCHAR (30)," +
                 CARD_COLUMN_FRONT_PHOTO + " INT, " +
                 CARD_COLUMN_BACK_PHOTO + " INT);"
        );


//____________________________________________________________________________________//


        String rejsekortCardNumber = objRejsekort.getCardNumber();
        Cursor rkCardIdFk = db.rawQuery("select " + CARD_COLUMN_CARD_ID + " from "
                + CARD_TABLE_NAME + " where " + CARD_COLUMN_CARD_TYPE + " = '"
                + rejsekortCardType + "'", null);
        rkCardIdFk.moveToFirst();
        String rejsekortCardIdFk = rkCardIdFk.getString(0);
        String rejsekortAmount = Integer.toString(objRejsekort.getAmount());

        db.execSQL(
                "CREATE TABLE " + RK_TABLE_NAME + "(" +
                        RK_COLUMN_CARD_NO + " VARCHAR(30) NOT NULL PRIMARY KEY, " +
                        CARD_COLUMN_CARD_ID + " INT NOT NULL, " +
                        RK_COLUMN_AMOUNT + " INT NOT NULL," +
                        "FOREIGN KEY (" + CARD_COLUMN_CARD_ID + ") REFERENCES "
                        + CARD_TABLE_NAME + " (" + CARD_COLUMN_CARD_ID + ")" +
                        ");"
        );

        db.execSQL("INSERT INTO " + RK_TABLE_NAME + " VALUES(" + rejsekortCardNumber + ","
                + rejsekortCardIdFk + "," + rejsekortAmount + ");"
        );
//_____________________________________________________________________________________//

        String bankcardCardNumber = objBankCard.getbCCardNumber();
        Cursor bcCardIdFk = db.rawQuery("select " + CARD_COLUMN_CARD_ID + " from "
                + CARD_TABLE_NAME + " where " + CARD_COLUMN_CARD_TYPE + " = '"
                + bankCardType + "'", null);
        bcCardIdFk.moveToFirst();
        String bankcardCardIdFk = bcCardIdFk.getString(0);
        String bankcardRegNo = objBankCard.getbCRegNumber();
        String bankcardAccountNo = objBankCard.getbCAccountNumber();
        String bankcardExpirationDate = objBankCard.getbCExpirationDate();
        String bankcardSecurityNo = objBankCard.getbCSecurityNumber();
        String bankcardAmount = Integer.toString(objBankCard.getbCAmount());

        db.execSQL(
                "CREATE TABLE " + BC_TABLE_NAME + "(" +
                        BC_COLUMN_CARD_NO + " VARCHAR(30) NOT NULL PRIMARY KEY, " +
                        CARD_COLUMN_CARD_ID + " INT NOT NULL, " +
                        BC_COLUMN_REG_NO + " INT NOT NULL, " +
                        BC_COLUMN_ACCOUNT_NO + " VARCHAR(30), " +
                        BC_COLUMN_EXPIRATION_DATE + " DATE, " +
                        BC_COLUMN_SECURITY_NO + " VARCHAR(4), " +
                        BC_COLUMN_AMOUNT + " INT NOT NULL, " +
                        "FOREIGN KEY (" + CARD_COLUMN_CARD_ID + ") REFERENCES "
                        + CARD_TABLE_NAME + " (" + CARD_COLUMN_CARD_ID + ")" +
                        ");"
        );

        db.execSQL("INSERT INTO " + BC_TABLE_NAME + " VALUES(" + bankcardCardNumber + ","
                + bankcardCardIdFk + "," + bankcardRegNo + ",'" + bankcardAccountNo + "','"
                + bankcardExpirationDate + "','" + bankcardSecurityNo + "'," + bankcardAmount + ");"
        );

//_______________________________________________________________________________________//

        String sundhedskortCardID = objSundhedskort.getsUID();
        Cursor skCardIdFk = db.rawQuery("select " + CARD_COLUMN_CARD_ID + " from "
                + CARD_TABLE_NAME + " where " + CARD_COLUMN_CARD_TYPE + " = '"
                + sundhedskortType + "'", null);
        skCardIdFk.moveToFirst();
        String sundhedskortCardIdFk = skCardIdFk.getString(0);
        String sundhedskortMunicipality = objSundhedskort.getsUMunicipality();
        String sundhedskortCity = objSundhedskort.getsUCity();
        String sundhedskortZipCode = objSundhedskort.getsUZip();
        String sundhedskortStreetName = objSundhedskort.getsUStreetName();
        String sundhedskortStreetNumber = objSundhedskort.getsUStreetNumber();
        String sundhedskortRegion = objSundhedskort.getsURegion();
        String sundhedskortDrFirstName = objSundhedskort.getsUDoctorFirstName();
        String sundhedskortDrLastName = objSundhedskort.getsUDoctorLastName();
        String sundhedskortDrCity = objSundhedskort.getsUDocCity();
        String sundhedskortDrZip = objSundhedskort.getsUDocZip();
        String sundhedskortDrStreetName = objSundhedskort.getsUDocStreetName();
        String sundhedskortDrStreetNumber = objSundhedskort.getsUDocStreetNumber();
        String sundhedskortDrPhone = objSundhedskort.getsUDocPhone();
        String sundhedskortValidDate = objSundhedskort.getsUValidDate();

        db.execSQL(
                "CREATE TABLE " + SK_TABLE_NAME + "(" +
                        SK_COLUMN_ID + " VARCHAR(30) NOT NULL PRIMARY KEY, " +
                        CARD_COLUMN_CARD_ID + " INT NOT NULL, " +
                        SK_COLUMN_MUNICIPALITY + " VARCHAR(30), " +
                        SK_COLUMN_CITY + " VARCHAR(20), " +
                        SK_COLUMN_ZIP_CODE + " INT NOT NULL, " +
                        SK_COLUMN_STREET_NAME + " VARCHAR(20), " +
                        SK_COLUMN_STREET_NUMBER + " VARCHAR(10), " +
                        SK_COLUMN_REGION + " VARCHAR(10), " +
                        SK_COLUMN_DR_FRIST_NAME + " VARCHAR(40), " +
                        SK_COLUMN_DR_LAST_NAME + " VARCHAR(40), " +
                        SK_COLUMN_DR_CITY + " VARCHAR(40), " +
                        SK_COLUMN_DR_ZIP + " INT NOT NULL, " +
                        SK_COLUMN_DR_STREET_NAME + " VARCHAR(40), " +
                        SK_COLUMN_DR_STREET_NUMBER + " VARCHAR(40), " +
                        SK_COLUMN_DR_PHONE + " INT NOT NULL, " +
                        SK_COLUMN_VALID_FROM + " DATE, " +
                        "FOREIGN KEY (" + CARD_COLUMN_CARD_ID + ") REFERENCES "
                        + CARD_TABLE_NAME + " (" + CARD_COLUMN_CARD_ID + ")" +
                        ");"
        );

        db.execSQL("INSERT INTO " + SK_TABLE_NAME + " VALUES(" + sundhedskortCardID + ","
                + sundhedskortCardIdFk + ",'" + sundhedskortMunicipality + "','"
                + sundhedskortCity + "'," + sundhedskortZipCode + ",'"
                + sundhedskortStreetName + "','" + sundhedskortStreetNumber + "','"
                + sundhedskortRegion + "','" + sundhedskortDrFirstName + "','"
                + sundhedskortDrLastName + "','" + sundhedskortDrCity + "',"
                + sundhedskortDrZip + ",'" + sundhedskortDrStreetName + "','"
                + sundhedskortDrStreetNumber + "'," + sundhedskortDrPhone + ",'"
                + sundhedskortValidDate + "');"
        );

//_______________________________________________________________________________________//

        /**String driverslicenceCardNumber = objDriversLicence.getdLCardNumber();
        Cursor dlCardIdFk = db.rawQuery("select " + CARD_COLUMN_CARD_ID + " from "
         + CARD_TABLE_NAME + " where " + CARD_COLUMN_CARD_TYPE + " = '"
         + driversLicenceType + "'", null);
        dlCardIdFk.moveToFirst();
        String driverslicenceCardIdFk = dlCardIdFk.getString(0);
        String driverslicenceDateOfBirth = objDriversLicence.getdLDateOfBirth();
        String driverslicenceCountryOfBirth = objDriversLicence.getdLCountryOfBirth();
        String driverslicenceIssueDate = objDriversLicence.getdLissuedDate();
        String driverslicenceExpirityDate = objDriversLicence.getdLExpirationDate();
        String driverslicenceIssuedBy = objDriversLicence.getdLIssuedBy();
        String driverslicenceCategory = objDriversLicence.getdLCategory();
        String driverslicenceCategoryDate = objDriversLicence.getdLCategoryIssueDate();
        String driverslicenceLimitations = objDriversLicence.getdLlimitation();

        db.execSQL(
                "CREATE TABLE " + DL_TABLE_NAME + "(" +
                        DL_COLUMN_CARD_NO + " INT NOT NULL PRIMARY KEY, " +
                        CARD_COLUMN_CARD_ID + " INT NOT NULL, " +
                        DL_COLUMN_DATE_OF_BIRTH + " DATE, " +
                        DL_COLUMN_COUNTRY_OF_BIRTH + " VARCHAR(20), " +
                        DL_COLUMN_ISSUE_DATE + " DATE, " +
                        DL_COLUMN_EXPIRITY_DATE + " DATE, " +
                        DL_COLUMN_ISSUED_BY + " VARCHAR(20), " +
                        DL_COLUMN_CATEGORIES_OF_LICENCED_VEHIVCLES + " VARCHAR(20), " +
                        DL_COLUMN_LICENCE_DATE_OF_CATEGORY + " DATE, " +
                        DL_LIMITATIONS + " VARCHAR(50), " +
                        "FOREIGN KEY (" + CARD_COLUMN_CARD_ID + ") REFERENCES "
                        + CARD_TABLE_NAME + " (" + CARD_COLUMN_CARD_ID + ")" +
                        ");"
        );

        db.execSQL("INSERT INTO " + DL_TABLE_NAME + " VALUES(" + driverslicenceCardNumber + ","
         + driverslicenceCardIdFk + ",'" + driverslicenceDateOfBirth + "','"
         + driverslicenceCountryOfBirth + "','" + driverslicenceIssueDate + "','"
         + driverslicenceExpirityDate + "','" + driverslicenceIssuedBy + "','"
         + driverslicenceCategory + "','" + driverslicenceCategoryDate + "','"
         + driverslicenceLimitations + "');"
        );*/

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

        db.execSQL("INSERT INTO drivers_licence VALUES(123456789, 3, '1992-04-12', 'Danmark', '2010-04-12', '2070-04-12', 'Rigspolitichefen','B', '1992-04-12', 'NULL' )"
        );
//_______________________________________________________________________________________//

        /**String ungdomskortCardNumber = objUngdomskort.getuKCardNumber();
        Cursor ukCardIdFk = db.rawQuery("select " + CARD_COLUMN_CARD_ID + " from "
                + CARD_TABLE_NAME + " where " + CARD_COLUMN_CARD_TYPE + " = '"
                + ungdomskortType + "'", null);
        ukCardIdFk.moveToFirst();
        String ungdomskortCardIdFk = ukCardIdFk.getString(0);
        String ungdomskortTravelZone = objUngdomskort.getuKtravelZone();
        String ungdomskortIssueDate = objUngdomskort.getuKIssuedDate();
        String ungdomskortExpirationDate = objUngdomskort.getuKExpirationDate();
        String ungdomskortDateOfBirth = objUngdomskort.getuKDateOfBirth();

        db.execSQL("CREATE TABLE " + UK_TABLE_NAME + "(" +
                        UK_COLUMN_CARD_NO + " VARCHAR(30) NOT NULL PRIMARY KEY, " +
                        CARD_COLUMN_CARD_ID + " INT NOT NULL, " +
                        UK_COLUMN_TRAVEL_ZONE + " VARCHAR(30), " +
                        UK_COLUMN_ISSUE_DATE + " DATE, " +
                        UK_COLUMN_EXPIRATION_DATE + " DATE, " +
                        UK_COLUMN_DATE_OF_BIRTH + " DATE, " +
                        "FOREIGN KEY (" + CARD_COLUMN_CARD_ID + ") REFERENCES "
                        + CARD_TABLE_NAME + " (" + CARD_COLUMN_CARD_ID + ")" +
                        ");"
        );

        db.execSQL("INSERT INTO " + UK_TABLE_NAME + " VALUES(" + ungdomskortCardNumber + ","
                + ungdomskortCardIdFk + ",'" + ungdomskortTravelZone + "','"
                + ungdomskortIssueDate + "','" + ungdomskortExpirationDate + "','"
                + ungdomskortDateOfBirth + "');"
        );*/

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
        }

        public void insertCard (String cardNameInput, int blueOrgreen, String barcode){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(OTHER_COLUMN_NAME, "'" + cardNameInput + "'" );
            contentValues.put(OTHER_COLUMN_BARCODE, "'" + barcode + "'" );
            contentValues.put(CARD_COLUMN_FRONT_PHOTO, blueOrgreen);
            contentValues.put(CARD_COLUMN_BACK_PHOTO, blueOrgreen);
            db.insert(OTHER_TABLE_NAME, null, contentValues);
        }

    public void deleteCard(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+OTHER_TABLE_NAME+" where " + CARD_COLUMN_CARD_ID + " = "+id);
    }
}


