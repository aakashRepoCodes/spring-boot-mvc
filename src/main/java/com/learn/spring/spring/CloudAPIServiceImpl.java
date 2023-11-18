package com.learn.spring.spring;

import com.learn.spring.spring.model.CloudVendor;
import com.learn.spring.spring.repository.CloudVendorRepository;
import com.learn.spring.spring.service.CloudAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CloudAPIServiceImpl implements CloudAPIService {

    CloudVendorRepository  cloudVendorRepository;

    public CloudAPIServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Vendor created successfully ... ";
    }

    @Override
    public CloudVendor getCloudVendorById(String id) {
        return cloudVendorRepository.findById(id).get();
    }

    @Override
    public CloudVendor updateCloudVendor(CloudVendor cloudVendor) {
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public String deleteCloudVendor(@RequestParam String id) {
        cloudVendorRepository.deleteById(id);
        return "Vendor deleted Successfully... ";
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
