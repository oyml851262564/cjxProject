package com.communication.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate方式的通信方式
 * @author Administrator
 *
 */
@RestController
@RequestMapping("communication/restTemplate")
public class RestTemplateController {
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	@Qualifier("rabbitRestTemplate")
	private RestTemplate restTemplate;
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/getServicePort")
	public String getServicePort() {
		return "shop is port:"+port;
	}
	
	@GetMapping("/getServiceA")
	public String getServiceA() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8001/common/showStr", String.class);//指定具体的地址跟软口访问服务
	}
	
	@GetMapping("/getServiceB")
	public String getServiceB() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("springcloud-common");//通过应用名获取应用的地址跟端口访问服务
		String url = String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/common/showStr");
		RestTemplate restTemplate = new RestTemplate();
	    String response = restTemplate.getForObject(url, String.class);
	    return response;
	}
	
	/**
	 * 必须要有ConfigBeans
	 * @return
	 */
	@GetMapping("/getServiceC")
	public String getServiceC() {
		return restTemplate.getForObject("http://springcloud-common/common/showStr", String.class);//直接通过应用名字访问服务
	}
}
