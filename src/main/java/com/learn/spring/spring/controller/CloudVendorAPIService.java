package com.learn.spring.spring.controller;

import com.learn.spring.spring.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

import java.sql.DataTruncation;
import java.util.Objects;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {

    private CloudVendor cloudVendor;

    @GetMapping("{vendorId}")
    public CloudVendor getCloudVendor(String vendorId) {
        return Objects.requireNonNullElseGet(cloudVendor, CloudVendor::new);
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor ) {
        this.cloudVendor = cloudVendor;
        return "Vendor Added successfully !";
    }

    @PutMapping
    public CloudVendor updateCloudVendor(@RequestBody String name ) {
        this.cloudVendor.setVendorName(name);
        return cloudVendor;
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(String vendorId ) {
        this.cloudVendor = null;
        return "Vendor deleted successfully !";
    }


}
