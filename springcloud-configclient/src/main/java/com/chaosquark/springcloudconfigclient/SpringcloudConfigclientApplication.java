package com.chaosquark.springcloudconfigclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class SpringcloudConfigclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigclientApplication.class, args);
    }

    /*@Value("${foo}")
    private String foo;

    @RequestMapping(value = "/hi")
    public String home() {
        return foo;
    }*/

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/hi")
    public String home() {
        return environment.getProperty("foo", "undefiend");
    }
}

