package com.example.gtxs.xa.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.gtxs", "com.netease.cloud.gtxs"})
@ImportResource(locations = {"classpath:repository-bean.xml"})
public class GtxsXaBranchApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtxsXaBranchApplication.class, args);
	}

}
