package com.ea.springbootdeneme.vendors.model;

import lombok.*;

@Data
@Builder
// Request modelimiz
public class VendorRequest {
    private  String name;
    private  String address;
    private  int year;
}
