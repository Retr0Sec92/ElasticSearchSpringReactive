package com.ea.springbootdeneme.vendors.repository;

import com.ea.springbootdeneme.vendors.entity.VendorEs;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;
import reactor.core.publisher.Flux;

public interface VendorElastic extends ReactiveElasticsearchRepository<VendorEs, String> {

    Flux<VendorEs> findByNameLikeOrAddressLike(String search, String Search);
}
