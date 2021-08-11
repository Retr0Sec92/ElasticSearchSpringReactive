package com.ea.springbootdeneme.vendors.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
// Response modelimiz
public class VendorResponse {
    private  String id;
    private  String name;
    private  String address;
    private  boolean trusted;
}
