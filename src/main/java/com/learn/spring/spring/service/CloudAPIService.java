package com.learn.spring.spring.service;

import com.learn.spring.spring.model.CloudVendor;

import java.util.List;

public interface CloudAPIService {

    public String createCloudVendor(CloudVendor  cloudVendor);
    public CloudVendor getCloudVendorById(String id);
    public CloudVendor updateCloudVendor(CloudVendor  cloudVendor);
    public String deleteCloudVendor(String id);
    public List<CloudVendor> getAllCloudVendor();

}
