package com.example.rasmus.p8_master;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

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


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }

            //test test test

        });
    }
}

