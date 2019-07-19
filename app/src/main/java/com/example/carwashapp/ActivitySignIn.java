package com.example.carwashapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mngClasses.MngServices;

public class ActivitySignIn extends AppCompatActivity {

    private static final int ADD_RECORD = 1;
    Button btnSignIn;
    //------------------------------------------//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        //------------------------------------------//
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivitySignIn.this,MainActivity.class);
                //intent.putExtra("DML_TYPE", "INSERT");
               // startActivityForResult(intent, ADD_RECORD);
               startActivity(intent);

            }
        });
    }
}
