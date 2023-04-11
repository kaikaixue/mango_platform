package com.xkk.mango.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.xkk.mango"})
public class MangoBackupApplication {
    public static void main(String[] args) {
        SpringApplication.run(MangoBackupApplication.class, args);
    }
}