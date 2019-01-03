package com.chaosquark.springcloudservicefeign.web.service;

import com.chaosquark.springcloudservicefeign.web.service.impl.TestServiceHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "springcloud-eurekaclient", fallback = TestServiceHystric.class)
public interface TestService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
