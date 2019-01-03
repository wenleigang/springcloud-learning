package com.chaosquark.springcloudservicefeign.web.controller;

import com.chaosquark.springcloudservicefeign.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    TestService testService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String home(@RequestParam String name) {
        return testService.sayHiFromClientOne(name);
    }
}
