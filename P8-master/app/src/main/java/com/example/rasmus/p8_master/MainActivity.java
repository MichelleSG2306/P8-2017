package com.example.rasmus.p8_master;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
        ListView lv = (ListView) findViewById(nameOfListView);
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
                if (position==1){
                    Intent myintent = new Intent (view.getContext(), Activity2.class);
                    startActivityForResult(myintent,1);}
            }
  }
}
