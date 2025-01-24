package org.example.inventoryservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/*
@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${global.params.p1}")
    private  String x;
    @Value("${global.params.p2}")
    private  String y;
    @Autowired
    private CustomerConfigParam customerConfigParam;

    @GetMapping("/testCOnfig1")
    public Map<String, String> configTest(){
        return  Map.of("p1",  x , "p2",y);
    }
    @GetMapping("/testCOnfig2")
    public CustomerConfigParam configTest2(){
        return  customerConfigParam;
    }

}
*/