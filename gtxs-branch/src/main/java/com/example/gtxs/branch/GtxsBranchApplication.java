package com.example.gtxs.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.gtxs", "com.netease.cloud.gtxs"})
public class GtxsBranchApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtxsBranchApplication.class, args);
	}

}
