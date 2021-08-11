package com.ea.springbootdeneme.vendors.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "vendors")
@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "id")
// Elastic Search Modelimiz
public class VendorEs {
    @Id
    private  String id;
    private  String name;
    private  String address;
    private  boolean active;
    private  int year;
}
