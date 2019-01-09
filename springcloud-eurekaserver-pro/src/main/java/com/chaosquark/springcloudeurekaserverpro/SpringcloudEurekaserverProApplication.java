package com.chaosquark.springcloudeurekaserverpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringcloudEurekaserverProApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaserverProApplication.class, args);
    }

}

