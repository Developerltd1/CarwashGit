package com.example.carwashapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mngClasses.MngServices;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    TextView party1Veh,party1Amount,party2Veh,party2Amount ;
    MngServices objServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Navigation Creation
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        objServices = new MngServices(this);
        dashboardComponents();

        //My Code...
      //  startActivity(new Intent());
    }

    public void dashboardComponents() {
        //------PARTY 01------------//
        party1Veh = (TextView)findViewById(R.id.party1Vehicle);
        party1Amount = (TextView)findViewById(R.id.party1_Amount);
        int[] a = new int[2];
        a= objServices.getServiceTotalVehicleAmount_WherePARTY1();
        party1Veh.setText(String.valueOf(a[0]));
        party1Amount.setText(String.valueOf(a[1]));

        //------PARTY 02------------//
        party2Veh = (TextView)findViewById(R.id.party2Vehicle);
        party2Amount = (TextView)findViewById(R.id.party2Amount);
        int[] b = new int[2];
        b= objServices.getServiceTotalVehicleAmount_WherePARTY2();
        party2Veh.setText(String.valueOf(b[0]));
        party2Amount.setText(String.valueOf(b[1]));

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,ActivitySignIn.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navDashboard) {
            // Handle the camera action
        } else if (id == R.id.navAddTableAdd) {
            startActivity(new Intent(MainActivity.this,ActivityHome.class));

        }else if (id == R.id.navTableDisplay) {
            startActivity(new Intent(MainActivity.this,ServicesList.class));

        }else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
