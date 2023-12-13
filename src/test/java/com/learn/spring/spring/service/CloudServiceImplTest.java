package com.learn.spring.spring.service;

import com.learn.spring.spring.CloudAPIServiceImpl;
import com.learn.spring.spring.model.CloudVendor;
import com.learn.spring.spring.repository.CloudVendorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CloudAPIServiceImplTest {

    @Mock
    private CloudVendorRepository cloudVendorRepository;

    @InjectMocks
    private CloudAPIServiceImpl cloudAPIService;

    public CloudAPIServiceImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCloudVendor() {
        CloudVendor cloudVendor = new CloudVendor();
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        String result = cloudAPIService.createCloudVendor(cloudVendor);

        verify(cloudVendorRepository, times(1)).save(cloudVendor);
        assertEquals("Vendor created successfully ... ", result);
    }

    @Test
    void getCloudVendorById() {
        String vendorId = "1";
        CloudVendor expectedVendor = new CloudVendor();
        when(cloudVendorRepository.findById(vendorId)).thenReturn(Optional.of(expectedVendor));

        CloudVendor result = cloudAPIService.getCloudVendorById(vendorId);

        verify(cloudVendorRepository, times(1)).findById(vendorId);
        assertEquals(expectedVendor, result);
    }

    @Test
    void updateCloudVendor() {
        CloudVendor cloudVendor = new CloudVendor();
        when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);

        CloudVendor result = cloudAPIService.updateCloudVendor(cloudVendor);

        verify(cloudVendorRepository, times(1)).save(cloudVendor);
        assertEquals(cloudVendor, result);
    }

    @Test
    void deleteCloudVendor() {
        String vendorId = "1";

        String result = cloudAPIService.deleteCloudVendor(vendorId);

        verify(cloudVendorRepository, times(1)).deleteById(vendorId);
        assertEquals("Vendor deleted Successfully... ", result);
    }

    @Test
    void getAllCloudVendor() {
        List<CloudVendor> expectedVendors = Arrays.asList(new CloudVendor(), new CloudVendor());
        when(cloudVendorRepository.findAll()).thenReturn(expectedVendors);

        List<CloudVendor> result = cloudAPIService.getAllCloudVendor();

        verify(cloudVendorRepository, times(1)).findAll();
        assertEquals(expectedVendors, result);
    }
}

