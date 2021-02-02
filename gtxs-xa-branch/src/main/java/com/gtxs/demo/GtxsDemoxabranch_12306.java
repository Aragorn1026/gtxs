package com.gtxs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gtxs.demo","com.netease.cloud.gtxs"})
@ImportResource(locations = {"classpath:repository-bean.xml"})
public class GtxsDemoxabranch_12306 {
    public static void main(String[] args){
        SpringApplication.run(GtxsDemoxabranch_12306.class,args);}
}
