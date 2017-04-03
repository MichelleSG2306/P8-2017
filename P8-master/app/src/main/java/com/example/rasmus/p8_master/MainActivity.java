package com.example.rasmus.p8_master;

import java.util.ArrayList;

import android.os.Bundle;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    public static int [] images ={R.drawable.rejsekort_f, R.drawable.ungdomskort_f, R.drawable.bankcard_f,
                                  R.drawable.sundhedskort_f, R.drawable.driverslicence_f};
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv=(ListView) findViewById(R.id.listOfCards);
        lv.setAdapter(new CustomAdapter(this, images));

    }

   /** @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

}
