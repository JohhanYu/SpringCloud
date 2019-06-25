package com.SpringCloud.EurekaFeign.Controller;

import com.SpringCloud.EurekaFeign.Service.consumer.EurekaFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EurekaFeignController {

    @Autowired
    private EurekaFeignService eurekaFeignService;

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        return eurekaFeignService.index();
    }
}
