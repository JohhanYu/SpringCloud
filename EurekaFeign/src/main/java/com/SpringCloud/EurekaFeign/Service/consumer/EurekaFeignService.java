package com.SpringCloud.EurekaFeign.Service.consumer;

import com.SpringCloud.EurekaFeign.Service.impl.EurekaFeignServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "eurekaclient",fallback = EurekaFeignServiceError.class)
public interface EurekaFeignService {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String index();
}
