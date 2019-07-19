package com.example.model;

public class Services {


    public Services(int vehicleID, String vehicleMake, String vehicleModel, String vehicleReg, String customerName, String contact, String serviceType, String amount, String party, String comments) {
        VehicleID = vehicleID;
        VehicleMake = vehicleMake;
        VehicleModel = vehicleModel;
        VehicleReg = vehicleReg;
        CustomerName = customerName;
        Contact = contact;
        ServiceType = serviceType;
        Amount = amount;
        Party = party;
        Comments = comments;
    }

    public  int  VehicleID;
    public  String  VehicleMake;
    public  String  VehicleModel;
    public  String  VehicleReg;
    public  String  CustomerName;
    public  String  Contact;
    public  String  ServiceType;
    public  String  Amount;
    public  String  Party;
    public  String  Comments;

    public Services() {
    }


    public int getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(int vehicleID) {
        VehicleID = vehicleID;
    }

    public String getVehicleMake() {
        return VehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        VehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return VehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        VehicleModel = vehicleModel;
    }

    public String getVehicleReg() {
        return VehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        VehicleReg = vehicleReg;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getParty() {
        return Party;
    }

    public void setParty(String party) {
        Party = party;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }


}
