
package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableFeignClients(basePackages = {"com.feign.service"}) //使用Feign通信方式增加此注解
@EnableEurekaClient //Eureka Client
public class ConsumeMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConsumeMain.class).web(true).run(args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate rabbitRestTemplate(){
        return new RestTemplate();
    }
}