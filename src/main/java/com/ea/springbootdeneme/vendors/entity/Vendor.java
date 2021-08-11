package com.ea.springbootdeneme.vendors.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendors")
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
// MongoDB modelimiz
public class Vendor {
    @Id
    private  String id;
    private  String name;
    private  String address;
    private  boolean active;
    private  int year;
}
