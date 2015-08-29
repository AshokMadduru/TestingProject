package com.dsquare.pacomeal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class PagerFragment extends Fragment {

    private int position;
    private ImageView pagerImage;
    private Bundle args;
    public PagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        args = getArguments();
        initializeObjects(view);
        getPosition();
        showData(position);
        return view;
    }
    public void initializeObjects(View view){
        pagerImage = (ImageView)view.findViewById(R.id.pager_image);
    }
    public void getPosition(){
        position = args.getInt("page_position");
    }
    public void showData(int position){
        switch (position){
            case 1:
                pagerImage.setImageDrawable(getActivity().getResources()
                        .getDrawable(R.drawable.one));
                break;
            case 2:
                pagerImage.setImageDrawable(getActivity().getResources()
                        .getDrawable(R.drawable.two));
                break;
            case 3:
                pagerImage.setImageDrawable(getActivity().getResources()
                        .getDrawable(R.drawable.three));
                break;
        }
    }
}