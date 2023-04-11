package com.xkk.mango.consumer.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ServiceController {

    @Resource
    LoadBalancerClient loadBalancerClient;

    @Resource
    DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     * @return
     */
    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("mango-producer");
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     * @return
     */
    @RequestMapping("/discover")
    public Object discover() {
        return loadBalancerClient.choose("mango-producer").getUri().toString();
    }
}
