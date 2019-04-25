package com.springboot.mybatisweb;

import com.springboot.mybatisweb.Service.MybatisUserService;
import com.springboot.mybatisweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private MybatisUserService mybatisUserService = null;

    @RequestMapping("/getUser")
    public User getUser(Long id){
        return  mybatisUserService.getUser(id);
    }
    @RequestMapping("/hello")
    public String hello(){
        return  "hello";
    }

}
