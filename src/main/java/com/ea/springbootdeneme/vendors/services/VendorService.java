package com.ea.springbootdeneme.vendors.services;

import com.ea.springbootdeneme.vendors.entity.Vendor;
import com.ea.springbootdeneme.vendors.entity.VendorEs;
import com.ea.springbootdeneme.vendors.model.VendorRequest;
import com.ea.springbootdeneme.vendors.model.VendorResponse;
import com.ea.springbootdeneme.vendors.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;
    private final VendorServiceEs vendorServiceEs;

    public Flux<VendorResponse> getAllVendors() {
        // Okuma işlemleri ElasticSearch üzerinden yapılmalıdır
        return vendorServiceEs.getAllFromEs();
    }

    public Mono<VendorResponse> getVendor(String id) {
        // Okuma işlemleri ElasticSearch üzerinden yapılmalıdır
        return vendorServiceEs.getFromEs(id);
    }

    public Flux<VendorResponse> getSearchResult(String search) {
        // Search ElasticSearch üzerinden yapılmalıdır
        return vendorServiceEs.searchNameAndAdress(search);
    }

    public Mono<VendorResponse> saveVendor(VendorRequest vendorRequest) {
        String uuid = UUID.randomUUID().toString();

        vendorRepository.save(Vendor.builder().year(vendorRequest.getYear())
                .name(vendorRequest.getName())
                .address(vendorRequest.getAddress())
                .active(true)
                .id(uuid).build());

        return vendorServiceEs.saveElastic(vendorRequest, uuid);
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
