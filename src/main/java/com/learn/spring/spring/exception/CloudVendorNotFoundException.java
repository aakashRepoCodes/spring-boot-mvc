package com.learn.spring.spring.exception;

public class CloudVendorNotFoundException extends RuntimeException {

    public CloudVendorNotFoundException(String message){
        super(message);
    }

    public CloudVendorNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }



}
