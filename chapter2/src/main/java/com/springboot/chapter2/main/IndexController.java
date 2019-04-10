package com.springboot.chapter2.main;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
