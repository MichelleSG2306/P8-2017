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

           Rejsekort obj = new Rejsekort("1", "123456789", 123);

           /*String rejsekortTableName = obj.getRejsekortTableName();
           String rejsekortColumnId = obj.getRejsekortColumnId();
           String rejsekortColumnCardnumber = obj.getRejsekortColumnCardnumber();
           String rejsekortColumnAmount = obj.getRejsekortColumnAmount(); */

           String rejsekortId = obj.getRejsekortId();
           String rejsekortCardnumber = obj.getRejsekortCardnumber();
           String rejsekortAmount = Integer.toString(obj.getRejsekortAmount());

        db.execSQL(
                "CREATE TABLE rejsekort (id INTEGER, cardNumber TEXT PRIMARY KEY, amount INTEGER);"
        );

        db.execSQL("INSERT INTO rejsekort (id , cardNumber, amount) VALUES(" + rejsekortId + "," + rejsekortCardnumber + "," + rejsekortAmount + ");"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS rejsekort;"); //+ PERSON_TABLE_NAME);
        //onCreate(db);
    }

}
