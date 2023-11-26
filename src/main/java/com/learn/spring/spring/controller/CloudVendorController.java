package com.learn.spring.spring.controller;

import com.learn.spring.spring.model.CloudVendor;
import com.learn.spring.spring.repository.CloudVendorRepository;
import com.learn.spring.spring.response.ResponseHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController implements HealthIndicator {

    @Autowired
    Environment env;

    private static final Logger logger =  LoggerFactory.getLogger(CloudVendor.class);
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorController(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendor(@PathVariable String vendorId) {

        if (cloudVendorRepository.findById(vendorId).isEmpty()) {
            logger.info("Requested vendor details not found:, HttpStatus.OK");
            return ResponseHandler.responseBuilder("Requested vendor details not found:", HttpStatus.OK, "");
        }
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


    private boolean isServiceUp() throws IOException {
        String address = env.getProperty("service1.address");
        String port = env.getProperty("service1.port");
        return isServiceReachable(address, Integer.parseInt(port), 3000);
    }


    private static boolean isServiceReachable(String address, int port, int timeout) throws IOException {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(address, port), timeout);
            return  true;
        } catch( IOException e) {
            return false;
        }finally {
            socket.close();
        }
    }

    @Override
    public Health health() {
        try {
            if (isServiceUp()) {
                return Health.up().withDetail("Service is up and running", "Success").build();
            } else{
                return Health.down().withDetail("Service is not running", "Failed").build();
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return null;
    }

}
