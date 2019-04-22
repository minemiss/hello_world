package com.springboot.chatpter02_demonewbook.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private JpaUserRespository jpaUserRespository = null;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id ){
        User user = jpaUserRespository.findById(id).get();
        return user;
    }
}
