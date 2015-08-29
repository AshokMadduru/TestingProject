package com.dsquare.pacomeal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by DsquareMar on 8/29/2015.
 */
public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private Integer[] categorImages={R.drawable.one,R.drawable.three,R.drawable.two
            ,R.drawable.three,R.drawable.welcome};
    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public int getCount() {
        return categorImages.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(categorImages[position]);
        return imageView;
    }
}
