package com.dsquare.pacomeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    private ImageView welcomeText;
    private Intent homeIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        initializeViews();
        initializeEventListeners();
    }
    public void initializeViews(){
        welcomeText = (ImageView)findViewById(R.id.welcome_text);
        homeIntent = new Intent(this,Home.class);
    }
    public void initializeEventListeners(){
        welcomeText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.welcome_text:
                startActivity(homeIntent);
                this.finish();
                break;
        }
    }
}
