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
    private static final int DATABASE_VERSION = 2;

    //Constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
   public void onCreate(SQLiteDatabase db) {

           Rejsekort obj = new Rejsekort("rejsekort", "1", "123456789", "123,-");

           String rejsekortTableName = obj.getRejsekortTableName();
           String rejsekortColumnId = obj.getRejsekortColumnId();
           String rejsekortColumnCardnumber = obj.getRejsekortColumnCardnumber();
           String rejsekortColumnAmount = obj.getRejsekortColumnAmount();

           String rejsekortId = obj.getRejsekortId();
           String rejsekortCardnumber = obj.getRejsekortCardnumber();
           String rejsekortAmount = obj.getRejsekortAmount();

        db.execSQL(
                "CREATE TABLE " + rejsekortTableName +
                        "(" + rejsekortColumnId + " INTEGER PRIMARY KEY, " +
                        rejsekortColumnCardnumber + " TEXT, " +
                        rejsekortColumnAmount + " TEXT  );"
        );

        db.execSQL("INSERT INTO" + rejsekortTableName + "(" + rejsekortColumnId + "," + rejsekortColumnCardnumber
                   + "," + rejsekortColumnAmount + ")" +
                "VALUES(" + rejsekortId + "," + rejsekortCardnumber + "," + rejsekortAmount + ");"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS rejsekort;"); //+ PERSON_TABLE_NAME);
        onCreate(db);
    }

    public Cursor getPerson(int id, String tableName, String columnId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + tableName + " WHERE " +
                columnId + "=?", new String[]{Integer.toString(id)});
        return res;
    }

}
