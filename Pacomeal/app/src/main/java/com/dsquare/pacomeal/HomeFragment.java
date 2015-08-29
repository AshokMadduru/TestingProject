package com.dsquare.pacomeal;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener{

    private HomePagerAdapter homePagerAdapter;
    private ViewPager viewPager;
    private Context context;
    private TextView changeCategory;
    private DialogFragment dialog;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        initializeObject(view);
        setPagerAdapter();
        initializeEventListeners();
        return view;
    }
    public void initializeObject(View view){
        changeCategory = (TextView)view.findViewById(R.id.category_change_text);
        viewPager = (ViewPager)view.findViewById(R.id.pager);
        homePagerAdapter = new HomePagerAdapter(getFragmentManager(),context);
    }
    public void setPagerAdapter(){
        viewPager.setAdapter(homePagerAdapter);
    }
    public void initializeEventListeners(){
        changeCategory.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.category_change_text:
                dialog = new CategoryDialog();
                dialog.show(getFragmentManager(),"category");
                break;
        }
    }
}
