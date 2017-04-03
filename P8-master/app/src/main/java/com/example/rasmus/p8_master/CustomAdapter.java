package com.example.rasmus.p8_master;

/**
 * Created by Rasmus on 29-03-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter{
    int[] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        //result=prgmNameList;
        result = prgmImages;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override

    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {

        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        final View rowView;
        rowView = inflater.inflate(R.layout.activity_list_img, null);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked An Image ", Toast.LENGTH_LONG).show();
                if (position == 0) {
                    Intent myintent = new Intent(context, Rejsekort.class);
                    //startActivityForResult(myintent, 0)
                    context.startActivity(myintent);
                }
                if (position == 1) {
                    Intent myintent = new Intent(context, DriversLicence.class);
                    context.startActivity(myintent);
                }
                if (position == 2) {
                    Intent myintent = new Intent(context, Sundhedskort.class);
                    context.startActivity(myintent);
                }
                if (position == 3) {
                    Intent myintent = new Intent(context, BankCard.class);
                    context.startActivity(myintent);
                }
                if (position == 4) {
                    Intent myintent = new Intent(context, Ungdomskort.class);
                    context.startActivity(myintent);
                }
            }
        });
        return rowView;
    }

}
