package com.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "feignService")
public interface FeignService {
    @RequestMapping("/findFeignMethodA")
    public String findFeignMethodA();

    @RequestMapping("/findFeignMethodB")
    public String findFeignMethodB();
}
