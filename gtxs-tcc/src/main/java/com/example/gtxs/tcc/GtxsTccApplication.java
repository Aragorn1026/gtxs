package com.example.gtxs.tcc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.gtxs", "com.netease.cloud.gtxs"})
public class GtxsTccApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtxsTccApplication.class, args);
	}

}
