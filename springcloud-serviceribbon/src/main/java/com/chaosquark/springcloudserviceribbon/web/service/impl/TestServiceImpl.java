package com.chaosquark.springcloudserviceribbon.web.service.impl;

import com.chaosquark.springcloudserviceribbon.web.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    @Override
    public String hello(String name) {
        return restTemplate.getForObject("http://SPRINGCLOUD-EUREKACLIENT/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi, " + name + " , sorry, error!";
    }
}
