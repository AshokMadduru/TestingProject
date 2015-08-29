package com.dsquare.pacomeal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by DsquareMar on 8/29/2015.
 */
public class NavDrawerAdapter extends BaseAdapter{
    private Context context;
    private String[] drawerItems;
    private TypedArray menuIcons;

    public NavDrawerAdapter(){

    }

    public NavDrawerAdapter(Context context){
        this.context = context;
        Resources resources = context.getResources();
        drawerItems = resources.getStringArray(R.array.drawer_items);
        menuIcons = resources.obtainTypedArray(R.array.drawer_icons);
    }

    @Override
    public int getCount() {
        return drawerItems.length;
    }

    @Override
    public Object getItem(int position) {
        return drawerItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.nav_drawer_list, parent, false);
            holder = new ViewHolder();
            holder.notifIcon = (ImageView)convertView.findViewById(R.id.imageView);
            holder.notifDesc = (TextView)convertView.findViewById(R.id.textView13);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.notifIcon.setBackgroundResource(menuIcons.getResourceId(position, -1));
        holder.notifDesc.setText((String) getItem(position));

        /*Typeface tf1 = Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Light.ttf");
        Typeface tf2=Typeface.createFromAsset(context.getAssets(),"fonts/Raleway-Medium.ttf");
        Typeface numbers = Typeface.createFromAsset(context.getAssets(),
                "fonts/AvenirLTStd-Book.otf");
        try{
            if(getItem(position).equals("Pill Remainder") ||
                    getItem(position).equals("About Only Health")){
                LinearLayout bottomLine=(LinearLayout)convertView.
                        findViewById(R.id.nav_bottom_line);
                bottomLine.setVisibility(View.GONE);
                LinearLayout topLayout=(LinearLayout)convertView.findViewById(R.id.nav_linear);
                ViewGroup.LayoutParams params=topLayout.getLayoutParams();
                int height= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80,
                        context.getResources().getDisplayMetrics());
                params.height=height;
                holder.notifIcon.setBackgroundResource(menuIcons.getResourceId(position, -1));
                holder.notifDesc.setText((String) getItem(position));
                holder.notifDesc.setTypeface(numbers);
            }else if(getItem(position)=="Home"){

                LinearLayout topLayout=(LinearLayout)convertView.findViewById(R.id.nav_linear);
                ViewGroup.LayoutParams params=topLayout.getLayoutParams();
                int height= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,
                        context.getResources().getDisplayMetrics());
                params.height=height;
                RelativeLayout nav=(RelativeLayout)convertView.findViewById(R.id.nav_layout);
                int padding= (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,80,
                        context.getResources().getDisplayMetrics());
                nav.setPadding(padding,0,0,0);
                holder.notifIcon.setBackgroundResource(menuIcons.getResourceId(position, -1));
                holder.notifDesc.setText((String) getItem(position));
                holder.notifDesc.setTypeface(numbers);
            }else{
                holder.notifIcon.setBackgroundResource(menuIcons.getResourceId(position, -1));
                holder.notifDesc.setText((String) getItem(position));
                holder.notifDesc.setTypeface(numbers);
            }

        }catch (Exception e){
            e.printStackTrace();
        }*/
        return convertView;
    }

    class ViewHolder{
        ImageView notifIcon;
        TextView notifDesc;
    }
}
