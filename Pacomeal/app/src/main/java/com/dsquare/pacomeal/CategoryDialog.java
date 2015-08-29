package com.dsquare.pacomeal;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;

/**
 * Created by DsquareMar on 8/29/2015.
 */
public class CategoryDialog extends DialogFragment {
    private AlertDialog.Builder builder;
    private LayoutInflater dialogInflater;
    private GridView gridView;
    private View view;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        builder = new AlertDialog.Builder(getActivity());
        dialogInflater = getActivity().getLayoutInflater();
        view  = dialogInflater.inflate(R.layout.category_dialog, null);
        gridView = (GridView)view.findViewById(R.id.gridview_dialog);
        gridView.setAdapter(new CategoryAdapter(getActivity()));
        builder.setView(view);
        return builder.create();
    }
}
