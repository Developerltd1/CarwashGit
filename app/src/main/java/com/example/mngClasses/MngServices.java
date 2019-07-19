package com.example.mngClasses;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.carwashapp.ActivityHome;
import com.example.model.Services;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import java.util.ArrayList;
import java.util.List;

public class MngServices extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Services mServies = new Services();


    //Database Variables
    public static final String DB_NAME = "CarWashDB.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "tblService";

   public static final String VehicleID = "VehicleID";
    public static final String VehicleMake = "VehicleMake";
    public static final String VehicleModel = "VehicleModel";
    public static final String VehicleReg = "VehicleReg";
    public static final String CustomerName = "CustomerName";
    public static final String Contact = "Contact";
    public static final String ServiceType = "ServiceType";
    public static final String Amount = "Amount";
    public static final String Party = "Party";
    public static final String Comments = "Comments";



    //TODO Constructor
    public MngServices(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
               db.execSQL("create table " + TABLE_NAME + " ( " + VehicleID + " INTEGER PRIMARY KEY AUTOINCREMENT," + VehicleMake + " TEXT, " + VehicleModel + " TEXT, " + VehicleReg + " TEXT, " + CustomerName + " TEXT, " + Contact + " TEXT, " + ServiceType + " TEXT, " + Amount + " TEXT, " + Party + " TEXT, " + Comments + " TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertService(Services mS){

        db = this.getWritableDatabase();
        db.execSQL("INSERT INTO " + TABLE_NAME + "(" + VehicleMake + "," + VehicleModel + "," + VehicleReg + "," + CustomerName + "," + Contact + "," + ServiceType + "," + Amount + "," + Party + "," + Comments + ") VALUES('" + mS.getVehicleMake() + "','" + mS.getVehicleModel() + "','" + mS.getVehicleReg() + "','" + mS.getCustomerName() + "','" + mS.getContact() + "','" + mS.getServiceType() + "','" + mS.getAmount() + "','" + mS.getParty() + "','" + mS.getComments() + "')");
        db.close();

            if(db.toString() == "-1")
                return false;
            else
                return true;
    }

    public ArrayList <Services> getAllService() {

        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select " + VehicleMake + "," + VehicleModel + "," + VehicleReg + "," + ServiceType + "," + Amount + "," + CustomerName + " from " + TABLE_NAME, null);
        int a = -1;

        ArrayList<Services>  lstmService = new ArrayList<Services>();
        if (c.moveToFirst()) {
          do{
            a++;
            Services servies = new Services();
              servies.setVehicleMake(c.getString(0));
              servies.setVehicleModel(c.getString(1));
              servies.setVehicleReg(c.getString(2));
              servies.setServiceType(c.getString(3));
              servies.setAmount(c.getString(4));
              servies.setCustomerName(c.getString(5));
            Log.d("ListError  ", String.valueOf(a + ": " + mServies.VehicleMake + " = " + mServies.VehicleModel + " = " + mServies.VehicleReg + " = " + mServies.ServiceType + " = " + mServies.Amount + " = " + mServies.CustomerName));
            lstmService.add(servies);
        }while (c.moveToNext());
        }

        c.close();
        db.close();
        return lstmService;
    }

    public int[] getServiceTotalVehicle_AND_Amount() {

        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select COUNT(" + VehicleID + "), SUM(" + Amount + ") from " + TABLE_NAME, null);
        int[]  arr = new int[2];
        if (c.moveToFirst()) {
            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);

             c.close();
            db.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }

    public int[] getServiceTotalVehicleAmount_WherePARTY1() {

        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select COUNT(" + VehicleID + "), SUM(" + Amount + ") from " + TABLE_NAME+ " WHERE "+Party+"= 1" , null);
        int[]  arr = new int[2];
        if (c.moveToFirst()) {
            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);

            c.close();
            db.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
    public int[] getServiceTotalVehicleAmount_WherePARTY2() {

        db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select COUNT(" + VehicleID + "), SUM(" + Amount + ") from " + TABLE_NAME+ " WHERE "+Party+"= 2" , null);
        int[]  arr = new int[2];
        if (c.moveToFirst()) {
            arr[0] = c.getInt(0);
            arr[1] = c.getInt(1);

            c.close();
            db.close();
        }
        while (c.moveToNext()) ;
        return arr;
    }
}

