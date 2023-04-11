package com.xkk.mango.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MangoProducerController {
    @Resource
    MangoProducerService mangoProducerService;

    @RequestMapping("/feign/hello")
    public String call() {
        return mangoProducerService.hello();
    }
}
