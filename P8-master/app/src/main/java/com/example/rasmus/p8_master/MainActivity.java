package com.example.rasmus.p8_master;






import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    SQLiteDatabase db;
    private DBHelper databaseHandler;



    /**public static int [] images ={R.drawable.rejsekort_f, R.drawable.driverslicence_f, R.drawable.sundhedskort_f,
                                  R.drawable.bankcard_f, R.drawable.ungdomskort_f};*/

    ArrayList<Integer> images=new ArrayList<Integer>();
    /**/
    ArrayList<String> titles=new ArrayList<String>();
    /**/
    int clickCounter=0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv=(ListView) findViewById(R.id.listOfCards);
        lv.setAdapter(new CustomAdapter(this, images, /**/titles/**/));

        int counter = getIntent().getIntExtra("COUNTER", 0);
        int counter2 = getIntent().getIntExtra("COUNTER2", 0);

        /*if(counter == 1){
            Toast.makeText(MainActivity.this, "Card added!", Toast.LENGTH_SHORT).show();

        }

        if (counter2 == 2){
            Toast.makeText(MainActivity.this, "Card deleted!", Toast.LENGTH_SHORT).show();
        } */

        //this.addStateItem();
 
        this.updateListView();

        //this.addImagesToListview();
        /**/
        this.addTitlesToListview();
        /**/

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
        /**/
        addTitlesToListview();
        /**/
        lv.invalidateViews();

    }

    public void updateAfterDelete(){
        lv.invalidateViews();
    }

    public void addImagesToListview() {
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        db = dbHelper.getReadableDatabase();
        Cursor getImages = db.rawQuery("Select front_photo from cards", null);
        getImages.moveToFirst();
        while (!getImages.isAfterLast()) {
            int image2 = getImages.getInt(0);
            images.add(image2);
            getImages.moveToNext();
        }

        Cursor getImages2 = db.rawQuery("Select front_photo from othercards", null);
        getImages2.moveToFirst();
        while (!getImages2.isAfterLast()) {
            int image2 = getImages2.getInt(0);
            images.add(image2);
            getImages2.moveToNext();

    }

    }
    /**/
    public void addTitlesToListview() {
        DBHelper dbHelper=new DBHelper(MainActivity.this);
        db=dbHelper.getReadableDatabase();
        Cursor getTitles=db.rawQuery("Select card_type from cards", null);
        getTitles.moveToFirst();
        while(!getTitles.isAfterLast()){
            String title2=getTitles.getString(0);
            titles.add(title2);
            getTitles.moveToNext();
        }

        Cursor getTitles2=db.rawQuery("Select name from othercards", null);
        getTitles2.moveToFirst();
        while(!getTitles2.isAfterLast()){
            String title2=getTitles2.getString(0);
            titles.add(title2);
            getTitles2.moveToNext();
        }

    }
    /**/


}

