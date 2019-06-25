package com.SpringCloud.EurekaFeign.Service.impl;

import com.SpringCloud.EurekaFeign.Service.consumer.EurekaFeignService;
import org.springframework.stereotype.Component;

@Component
public class EurekaFeignServiceError implements EurekaFeignService {

    @Override
    public String index() {
        return "服务发生故障!";
    }
}
