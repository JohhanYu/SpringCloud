package com.SpringCloud.EurekaFeign;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class EurekaFeign {
    public static void main(String[] args) {
        SpringApplication.run(EurekaFeign.class,args);
    }
}
