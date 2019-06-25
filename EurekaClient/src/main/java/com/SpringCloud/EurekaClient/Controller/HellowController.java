package com.SpringCloud.EurekaClient.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellowController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "Hello World!,端口："+port;
    }

}
