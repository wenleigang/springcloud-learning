package com.chaosquark.springcloudservicefeign.web.service.impl;

import com.chaosquark.springcloudservicefeign.web.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceHystric implements TestService {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }
}
