package com.woniu.springboot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String hello(Map<String,Object> map){

        map.put("hello","你好啊，我是hello的value");
        return "success";
    }
}
