package com.SpringCloud.EurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringCloudApplication
public class EurekaClientAppliCation {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientAppliCation.class,args);
    }
}
