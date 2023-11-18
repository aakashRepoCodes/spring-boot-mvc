package com.learn.spring.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value = { CloudVendorNotFoundException.class} )
    public ResponseEntity<Object> handleNotFoundException(CloudVendorNotFoundException notFoundException) {

        CloudVendorException exception = new CloudVendorException(notFoundException.getMessage(),
                notFoundException.getCause(),
                HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

}
