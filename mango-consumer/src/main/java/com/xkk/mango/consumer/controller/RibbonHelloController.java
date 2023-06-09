package com.xkk.mango.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RibbonHelloController {

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("/ribbon/call")
    public String call() {
        // 调用服务，service-producer为注册的服务名称
        // LoadBalancerInterceptor会拦截调用并根据服务名找到对应的的服务
        String callServiceResult = restTemplate.getForObject("http://mango-producer/hello", String.class);
        return callServiceResult;
    }
}
