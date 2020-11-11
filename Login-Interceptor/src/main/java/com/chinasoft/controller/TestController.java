package com.chinasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "/aaa")
    public String test(){
        return "success";
    }

    @RequestMapping(value = "/bbb")
    public String test1(){
        return "success";
    }

    @RequestMapping(value = "/ccc")
    public String test2(){
        return "success";
    }
}
