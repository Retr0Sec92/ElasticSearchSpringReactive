package com.ea.springbootdeneme.vendors.api;

import com.ea.springbootdeneme.vendors.model.VendorRequest;
import com.ea.springbootdeneme.vendors.model.VendorResponse;
import com.ea.springbootdeneme.vendors.services.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vendors")
@RequiredArgsConstructor
public class VendorsApi {
    private final VendorService vendorService;

    @GetMapping
    public Flux<VendorResponse> getVendors() {
        return  vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Mono<VendorResponse> getVendor(@PathVariable String id) {
        return  vendorService.getVendor(id);
    }

    @PostMapping
    public Mono<VendorResponse> saveVendor(@RequestBody VendorRequest vendorRequest) {
        return  vendorService.saveVendor(vendorRequest);
    }

    @GetMapping("/search/{search}")
    public Flux<VendorResponse> getSearch(@PathVariable String search) {
        return  vendorService.getSearchResult(search);
    }
}
