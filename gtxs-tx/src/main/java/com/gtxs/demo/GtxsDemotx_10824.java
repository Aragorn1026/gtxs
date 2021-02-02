package com.gtxs.demo;
import org.springframework.context.annotation.ComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@ComponentScan(basePackages = {"com.gtxs.demo", "com.netease.cloud.gtxs"})
//@MapperScan(basePackages = "com.gtxs.demo.dao")
public class GtxsDemotx_10824 {
    public static void main(String[] args){
        SpringApplication.run(GtxsDemotx_10824.class,args);
    }
}
