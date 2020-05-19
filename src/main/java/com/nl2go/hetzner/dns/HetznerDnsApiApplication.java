package com.nl2go.hetzner.dns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HetznerDnsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HetznerDnsApiApplication.class, args);
    }

}

