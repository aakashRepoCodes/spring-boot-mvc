package com.learn.spring.spring.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(
            String message,
            HttpStatus httpStatus,
            Object responseBody) {

        Map <String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("status", httpStatus);
        map.put("data", responseBody);
        return new ResponseEntity<>(map, httpStatus);
    }

}
