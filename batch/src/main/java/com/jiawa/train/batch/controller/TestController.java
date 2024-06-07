package com.jiawa.train.batch.controller;

import com.jiawa.train.batch.feign.BusinessFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    @Autowired
    BusinessFeign businessFeign;
    @GetMapping("/hello")

    public String hello(){

        String s = businessFeign.hello1();
        LOG.info(s);
        return "Batch";
    }


}
