package com.dsquare.pacomeal;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Home extends AppCompatActivity implements DrawerCallback
        ,AdapterView.OnItemClickListener{

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private DrawerLayout drawer;
    private ListView drawerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeObjects();
        initializeDrawerAdapter();
        initializeEventListeners();
        loadDefaultFragment();
    }
    public void initializeObjects(){
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        manager = getSupportFragmentManager();
        drawerList = (ListView)findViewById(R.id.drawerList);
    }
    public void initializeDrawerAdapter(){
        drawerList.setAdapter(new NavDrawerAdapter(this));
    }
    public void initializeEventListeners(){
        drawerList.setOnItemClickListener(this);
    }
    public void loadDefaultFragment(){
        transaction = manager.beginTransaction();
        transaction.replace(R.id.content_frame, new HomeFragment());
        transaction.commit();
    }
    @Override
    public void drawerOpen() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void hideDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }
    @Override
    public void replaceFragment(int position) {
        replaceWithNewFragment(position);
    }
    private void replaceWithNewFragment(int position){
        transaction = manager.beginTransaction();
        switch (position){
            case 0:
                transaction.replace(R.id.content_frame, new HomeFragment());
                transaction.commit();
                break;
            case 1:
                //transaction.replace(R.id.frame_container,new VitalsFragment());
                break;
            case 2:
               // transaction.replace(R.id.frame_container,new OffersFragment());
                break;
            case 3:
                //transaction.replace(R.id.frame_container,new HealthTipsFragment());
                break;
            case 4:
                //transaction.replace(R.id.frame_container,new HealthRecordsFragment());
                break;
            case 5:
                //transaction.replace(R.id.frame_container,new AppointmentFramgment());
                break;
            case 6:
                //transaction.replace(R.id.frame_container,new PillRemainderFragment());
                break;
            case 7:
                //transaction.replace(R.id.frame_container,new Settings());
                break;
            case 8:
                //transaction.replace(R.id.frame_container,new AboutOnlyHealth());
                break;
        }

        hideDrawer();
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        replaceWithNewFragment(position);
    }
}
