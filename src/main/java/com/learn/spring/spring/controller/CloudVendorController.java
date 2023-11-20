package com.learn.spring.spring.controller;

import com.learn.spring.spring.model.CloudVendor;
import com.learn.spring.spring.repository.CloudVendorRepository;
import com.learn.spring.spring.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorController(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendor(@PathVariable String vendorId) {

        if (cloudVendorRepository.findById(vendorId).isEmpty())
            return ResponseHandler.responseBuilder("Requested vendor details not found:", HttpStatus.OK, "");

        return ResponseHandler.responseBuilder("Requested vendor details :", HttpStatus.OK, cloudVendorRepository.findById(vendorId).get());
    }

    @GetMapping("/fetchvendors")
    public List<CloudVendor> getAllCloudVendors() {
        return cloudVendorRepository.findAll();
    }

    @PostMapping
    public String createCloudVendor(@RequestBody CloudVendor cloudVendor ) {
        cloudVendorRepository.save(cloudVendor);
        return "Vendor Added successfully !";
    }

    @PutMapping
    public CloudVendor updateCloudVendor(@RequestBody CloudVendor cloudVendor ) {
        CloudVendor cloudVendor1 =  cloudVendorRepository.findById(cloudVendor.vendorID).get();
        cloudVendor1.setVendorName(cloudVendor.vendorName);
        cloudVendor1.setVendorPhoneNumber(cloudVendor.vendorPhoneNumber);
        cloudVendor1.setVendorAddress(cloudVendor.vendorAddress);
        cloudVendorRepository.save(cloudVendor1);
        return cloudVendor;
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendor(@PathVariable String vendorId ) {
        cloudVendorRepository.deleteById(vendorId);
        return "Vendor deleted successfully !";
    }

}
