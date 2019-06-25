package com.SpringCloud.Config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringCloudApplication
@EnableConfigServer
public class EurekaConfig {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfig.class,args);
    }
}
