
package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //Eureka Client
@EnableFeignClients //使用Feign通信方式增加此注解
public class CommonMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CommonMain.class).web(true).run(args);
    }

    /**
     * rabbit负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate rabbitRestTemplate(){
        return new RestTemplate();
    }
}