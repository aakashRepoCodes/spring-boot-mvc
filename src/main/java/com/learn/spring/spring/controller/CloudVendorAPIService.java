package com.learn.spring.spring.controller;

import com.learn.spring.spring.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    private CloudVendor cloudVendor;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendor(String vendorId) {

        return new CloudVendor ("1", "Amazon", "987654321", "USA");
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor ) {
        this.cloudVendor = cloudVendor;
        return "Vendor Added successfully !";

    }

}
