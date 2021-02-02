package com.example.gtxs.xa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.gtxs.xa", "com.netease.cloud.gtxs", "com.example.gtxs.xa.branch", "com.example.gtxs.api", "com.example.gtxs","com.example.gtxs.branch"})
@ImportResource(locations = {"classpath:repository-bean.xml"})
public class GtxsXaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtxsXaApplication.class, args);
	}

}
