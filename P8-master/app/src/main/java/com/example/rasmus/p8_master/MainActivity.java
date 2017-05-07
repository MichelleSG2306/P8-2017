package com.example.rasmus.p8_master;






import android.Manifest;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import android.util.Log;
import android.util.Pair;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    SQLiteDatabase db;
    private DBHelper databaseHandler;



    /**public static int [] images ={R.drawable.rejsekort_f, R.drawable.driverslicence_f, R.drawable.sundhedskort_f,
                                  R.drawable.bankcard_f, R.drawable.ungdomskort_f};*/

    ArrayList<Integer> images=new ArrayList<Integer>();
    int clickCounter=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv=(ListView) findViewById(R.id.listOfCards);
        lv.setAdapter(new CustomAdapter(this, images));

        //this.addStateItem();
        this.addImagesToListview();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent = new Intent(this, AddNewCard.class);
        startActivity(intent);
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_name) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateListView(){
        addImagesToListview();
        lv.invalidateViews();

    }

    public void addImagesToListview() {
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        db = dbHelper.getReadableDatabase();
        Cursor getImages = db.rawQuery("Select front_photo from cards", null);
        getImages.moveToFirst();
        while(!getImages.isAfterLast()) {
            //String image = getImages.getString(0);
            //int image2 = Integer.parseInt(image);
            int image2 = getImages.getInt(0);
            images.add(image2);
            getImages.moveToNext();
            }

    }


}

