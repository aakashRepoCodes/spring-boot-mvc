package com.learn.spring.spring;

import com.learn.spring.spring.model.CloudVendor;
import com.learn.spring.spring.repository.CloudVendorRepository;
import com.learn.spring.spring.service.CloudAPIService;

import java.util.List;

public class CloudAPIServiceImpl implements CloudAPIService {

    private CloudVendorRepository  cloudVendorRepository;

    public CloudAPIServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }

    @Override
    public CloudVendor createCloudVendor(CloudVendor cloudVendor) {
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public CloudVendor getCloudVendorById(String id) {
        return cloudVendorRepository.getReferenceById(id);
    }

    @Override
    public CloudVendor updateCloudVendor(CloudVendor cloudVendor) {
        return cloudVendorRepository.save(cloudVendor);
    }

    @Override
    public String deleteCloudVendor(String id) {
        cloudVendorRepository.deleteById(id);
        return "Vendor deleted Successfully... ";
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
