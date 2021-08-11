package com.ea.springbootdeneme.vendors.services;

import com.ea.springbootdeneme.vendors.entity.VendorEs;
import com.ea.springbootdeneme.vendors.model.VendorRequest;
import com.ea.springbootdeneme.vendors.model.VendorResponse;
import com.ea.springbootdeneme.vendors.repository.VendorElastic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VendorServiceEs {
    private final VendorElastic vendorElastic;

    public Mono<VendorResponse> saveElastic(VendorRequest vendor, String uuid) {
        return vendorElastic.save(VendorEs.builder().active(true)
                .year(vendor.getYear())
                .name(vendor.getName())
                .address(vendor.getAddress())
                .id(uuid).build()).map(this::mapToResponse);
    }

    public Flux<VendorResponse> getAllFromEs() {
        return vendorElastic.findAll().map(this::mapToResponse);
    }

    public Mono<VendorResponse> getFromEs(String id) {
        return vendorElastic.findById(id).map(this::mapToResponse);
    }

    public Flux<VendorResponse> searchNameAndAdress(String search) {
        return vendorElastic.findByNameLikeOrAddressLike(search, search).map(this::mapToResponse);
    }

    private VendorResponse mapToResponse(VendorEs vendorEs) {
        return VendorResponse.builder().id(vendorEs.getId())
                .name(vendorEs.getName())
                .address(vendorEs.getAddress())
                .trusted(this.checkTrustability(vendorEs.getYear()))
                .build();
    }

    public boolean checkTrustability(int year) {
        if(year >= 5) {
            return true;
        }
        else {
            return false;
        }
    }
}
