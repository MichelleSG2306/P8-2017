package com.example.rasmus.p8_master;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by babis on 4/11/2017.
 */

public class SwipeAdapter extends PagerAdapter {


    private int[] images;
    private LayoutInflater inflater;
    private Context context;

    public SwipeAdapter (Context context){
        this.context=context;
    }


    public void setImagesValue(int[] im){
        images=im;
    }




    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.swipe,container,false);
        ImageView img=(ImageView)view.findViewById(R.id.imageView);
        img.setImageResource(images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
