package com.learn.spring.spring.repository;

import com.learn.spring.spring.model.CloudVendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface CloudVendorRepository extends MongoRepository<CloudVendor, String > {
}
