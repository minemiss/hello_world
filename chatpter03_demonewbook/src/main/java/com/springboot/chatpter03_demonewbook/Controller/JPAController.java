package com.springboot.chatpter03_demonewbook.Controller;


import com.springboot.chatpter03_demonewbook.Object.Girl;
import com.springboot.chatpter03_demonewbook.Object.SexEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JPAController{

    @Autowired
    public GirlProperties girlProperties;

    @RequestMapping("/sql")
    public String helloSQL(){
        return "hello";
    }

    @RequestMapping("/findall")
    public List<Girl> girllist(){
            return girlProperties.findAll();
    }

    @RequestMapping(value = "/girls")
    public  Girl girlAdd(@RequestParam("cupSize") String cupSize,//ontroller方法中的参数名称要跟form中name名称一致
                         @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setNote(cupSize);
        girl.setUserName("age");
        girl.setSex(SexEnum.FEMALE);

        return girlProperties.save(girl);
    }

}
