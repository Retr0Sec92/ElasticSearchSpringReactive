package com.ea.springbootdeneme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories
@SpringBootApplication
public class SpringBootDenemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDenemeApplication.class, args);
	}

}
