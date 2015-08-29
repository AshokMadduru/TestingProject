package com.dsquare.pacomeal;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by DsquareMar on 8/29/2015.
 */
public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private Context context;
    public HomePagerAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt("page_position", position + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
