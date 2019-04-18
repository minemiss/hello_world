package com.spring.chatpter01_demonewbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class excute {
    @RequestMapping("/excute")
    public String helloexcute(Map<String,Object> map){
        map.put("name","as");
        return "success";
    }
}
