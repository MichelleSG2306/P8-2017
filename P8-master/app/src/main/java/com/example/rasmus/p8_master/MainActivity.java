package com.example.rasmus.p8_master;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.rasmus.p8_master.R.id.listOfCards;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** This is what Maja did. I need to implement my part in this!
        ListView lv = (ListView) findViewById(listOfCards);
        final String [] values = new String[]{"den første", "den anden"};
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.activity_list_item, android.R.id.text1, values);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){
                if (position == 0) {
                    Intent myintent = new Intent (view.getContext(), Activity1.class);
                    startActivityForResult(myintent,0);
                }
                if (position == 1){
                    Intent myintent = new Intent (view.getContext(), Activity2.class);
                    startActivityForResult(myintent,1);
                }
            }
        }); */
    }

}
