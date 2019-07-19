package com.example.carwashapp;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adapter.ServicesAdapter;
import com.example.mngClasses.MngServices;
import com.example.model.Services;

import java.util.ArrayList;

public class ServicesList extends AppCompatActivity {

    ServicesAdapter adapter;
    ArrayList<Services> sList;
    MngServices objServices;
    ListView lvListID; //Header-List_ID

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);//Main List Layout
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
       objServices = new MngServices(this);
        tableRows();
       tableTotalRow();
    }

    private void tableTotalRow() {
        TextView strAm = (TextView) findViewById(R.id.totalAmount);
        TextView strVh = (TextView) findViewById(R.id.totalVehicle);
        int[] a = new int[2];
        a= objServices.getServiceTotalVehicle_AND_Amount();
        strVh.setText(String.valueOf(a[0]));
        strAm.setText(String.valueOf(a[1]));
    }

    private void tableRows() {
        lvListID =(ListView) findViewById(R.id.ServicesList);
        sList =objServices.getAllService();  // Assigning to List From MngServices Class
        adapter = new ServicesAdapter( ServicesList.this,sList);
        lvListID.setAdapter(adapter);
    }
}
