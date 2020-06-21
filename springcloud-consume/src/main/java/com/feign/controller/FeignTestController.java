package com.feign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feginTest")
public class FeignTestController {
    @Value("${server.port}")
    private String port;

//    @Resource
//    private FeignService feignService;

//    @GetMapping("/findFeignMethodA")
//    public String findFeignMethodA(){
//        return feignService.findFeignMethodA();
//    }
//
//    @GetMapping("/findFeignMethodB")
//    public String findFeignMethodB(){
//        return feignService.findFeignMethodB();
//    }
}
