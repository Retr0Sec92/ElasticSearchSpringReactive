package com.ea.springbootdeneme.vendors.repository;

import com.ea.springbootdeneme.vendors.entity.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {

}
