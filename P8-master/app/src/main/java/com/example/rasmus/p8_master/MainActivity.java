package com.example.rasmus.p8_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    MainActivity context;


    ArrayList imgCards;
    public static int[] images = {R.drawable.img_rejsekort, R.drawable.img_koerekort, R.drawable.img_sundhedskort,
            R.drawable.img_creditcard, R.drawable.img_ungdomskort};
    public static String[] prgmNameList = {"Let Us C", "hejej", "hehrej", "hehej", "jugjug"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        lv = (ListView) findViewById(R.id.listOfCards);
        lv.setAdapter(new CustomAdapter(this, prgmNameList, images));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }

            //test test test

        });
    }
}

