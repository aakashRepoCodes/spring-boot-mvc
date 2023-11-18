package com.learn.spring.spring.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class CloudVendor {

    @MongoId
    public String vendorID;
    public String vendorName;
    public String vendorPhoneNumber;
    public String vendorAddress;

    public CloudVendor(){}

    public CloudVendor(String vendorID, String vendorName, String vendorPhoneNumber, String vendorAddress) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.vendorPhoneNumber = vendorPhoneNumber;
        this.vendorAddress = vendorAddress;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorPhoneNumber() {
        return vendorPhoneNumber;
    }

    public void setVendorPhoneNumber(String vendorPhoneNumber) {
        this.vendorPhoneNumber = vendorPhoneNumber;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }
}
