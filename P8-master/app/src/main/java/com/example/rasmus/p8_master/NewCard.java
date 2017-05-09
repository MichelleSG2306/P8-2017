package com.example.rasmus.p8_master;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class NewCard extends Card {

    public String barcode;
    public String nameOfCard;
    //String s = getIntent().getStringExtra("EXTRA_POSITION_ID");
    SQLiteDatabase db;

    public NewCard(){

    }

    public NewCard(String cardID, String type, int frontPhoto, int backPhoto, String barcode, String nameOfCard) {
        super(cardID, type, frontPhoto, backPhoto);
        this.barcode = barcode;
        this.nameOfCard = nameOfCard;
    }

    SwipeAdapter swipeAdapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card);


        //Swipe Function
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        swipeAdapter=new SwipeAdapter(this);
        swipeAdapter.setImagesValue(new int[]{R.drawable.othercardb, R.drawable.othercardf});
        viewPager.setAdapter(swipeAdapter);

        //dots
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);

        int id2 = getIntent().getIntExtra("EXTRA_POSITION_ID", 0);
        int minus = 4;
        id2 = id2 - minus ;

        DBHelper dbHelper = new DBHelper(NewCard.this);
        db = dbHelper.getReadableDatabase();

        Cursor name = db.rawQuery("Select name from othercards where card_id =" + id2 ,null);
        name.moveToFirst();
        String name2 = name.getString(0);
        TextView textName = (TextView) findViewById(R.id.nameOfCard);
        textName.append(" " + name2);

        Cursor barcode = db.rawQuery("Select barcode from othercards where card_id =" + id2 ,null);
        barcode.moveToFirst();
        String barcode2 = barcode.getString(0);
        TextView textBarcode = (TextView) findViewById(R.id.barcode);
        textBarcode.append(" " + barcode2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_card, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //Intent intent = new Intent(this, AddNewCard.class);
        //startActivity(intent);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to delete?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int id2 = getIntent().getIntExtra("EXTRA_POSITION_ID", 0);
                        int minus = 4;
                        id2 = id2 - minus ;
                        Toast.makeText(NewCard.this, "Card deleted", Toast.LENGTH_SHORT).show();
                        DBHelper dbHelper = new DBHelper(NewCard.this);
                        dbHelper.deleteCard(id2);
                        int counter = 2;
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        //intent.putExtra("COUNTER2", counter);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        AlertDialog d = builder.create();
        d.setTitle("Delete Card?");
        d.show();



       // int id2 = getIntent().getIntExtra("EXTRA_POSITION_ID", 0);
       // int minus = 4;
       // id2 = id2 - minus ;

        //if (id2 > 4) {
            //int id = Integer.valueOf(s);
            //DBHelper dbHelper = new DBHelper(NewCard.this);
            //dbHelper.deleteCard(id2);
            //The key argument here must match that used in the other activity
        //}




        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public String getBarcode() {
        return barcode;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }
}
