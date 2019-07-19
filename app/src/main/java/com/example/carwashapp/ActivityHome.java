package com.example.carwashapp;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mngClasses.MngServices;
import com.example.model.Services;

public class ActivityHome extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spMake, spService,spParty;
    ArrayAdapter<CharSequence> arrayAdapter;
    EditText edtvehicleModel, edtVreg, edtCustomerName, edtContact,edtAmount, edtComment;
   // String _edtComment; //_spMake, _spService, _edtvehicleModel, _edtVreg, _edtCustomerName, _edtContact, _edtAmount, _edtParty,
    Button btnSave;

    Services mService = new Services();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initilize();
        spService.setOnItemSelectedListener(this);
        AddData();

    }

    public void initilize(){
        // Components
        spMake = findViewById(R.id.spVehicleMake);
        spService = findViewById(R.id.spService);
        edtvehicleModel = findViewById(R.id.edtVModel);
        edtVreg = findViewById(R.id.edtVRegNo);
        edtCustomerName = findViewById(R.id.edtCustomerName);
        edtContact = findViewById(R.id.edtContact);
        edtAmount = findViewById(R.id.edtPrice);
        spParty = findViewById(R.id.spParty);
        edtComment = findViewById(R.id.edtComments);

        //ComboBox 1
        // String [] cbvehicleMake =new String[]{"Toyota1","Honda","Suzuki","BMW","Faw"};


                arrayAdapter = ArrayAdapter.createFromResource(this,R.array._Party,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spParty.setAdapter(arrayAdapter);

        arrayAdapter = ArrayAdapter.createFromResource(this,R.array._vehicleMake,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spMake.setAdapter(arrayAdapter);
        //ComboBox 2
        spMake.setOnItemSelectedListener(this);
        arrayAdapter = ArrayAdapter.createFromResource(this,R.array._serviceType,R.layout.support_simple_spinner_dropdown_item);
        arrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spService.setAdapter(arrayAdapter);

        //Buttons
        btnSave = findViewById(R.id.btnSave);
    }

    public void AddData(){


        //TODO Insert
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
try {
    MngServices objService = new MngServices(ActivityHome.this);
    //if(_spMake.length() != 0 || _spService.length() != 0 || _edtvehicleModel.length() != 0 || _edtVreg.length() != 0 || _edtCustomerName.length() != 0 || _edtContact.length() != 0 || _edtAmount.length() != 0 || _edtParty.length() != 0) {
    //_edtComment = edtComment.getText().toString();
          mService.setVehicleMake(spMake.getSelectedItem().toString());
          mService.setServiceType(spService.getSelectedItem().toString());
          mService.setVehicleModel(edtvehicleModel.getText().toString());
          mService.setVehicleReg(edtVreg.getText().toString());
          mService.setCustomerName(edtCustomerName.getText().toString());
          mService.setContact(edtContact.getText().toString());
          mService.setAmount(edtAmount.getText().toString());
          mService.setParty(spParty.getSelectedItem().toString());
          mService.setComments(edtComment.getText().toString());

     if (objService.insertService(mService) == true) {

         Toast.makeText(ActivityHome.this, "Data Inserted Successfully ! ", Toast.LENGTH_SHORT).show();
     } else {
         Toast.makeText(ActivityHome.this, "Data Inserted Error", Toast.LENGTH_SHORT).show();
     }
 //}else {
   //  Toast.makeText(ActivityHome.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();}

}catch(Exception e){
    Toast.makeText(ActivityHome.this, "Error: "+e, Toast.LENGTH_SHORT).show();
}
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
