package com.learn.spring.spring.repository;

import com.learn.spring.spring.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String > {
}
