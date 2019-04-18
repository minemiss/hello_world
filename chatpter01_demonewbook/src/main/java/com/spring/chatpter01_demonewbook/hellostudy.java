package com.spring.chatpter01_demonewbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class hellostudy {


    @RequestMapping("/study")
    public String hellostudy(Map<String,Object> map , HttpServletRequest request) {
        List<User> userlist = new ArrayList<>();
        userlist.add(new User("li", 1));
        userlist.add(new User("wang",2));
        userlist.add(new User("xie",1));
        System.out.println(userlist.get(0).getAge()+" "+userlist.get(1).getAge()+" "+userlist.get(2).getAge());
        map.put("userList",userlist);
        map.put("sex","1");
        map.put("man ","man");
        map.put("decs","lll");

        request.getSession().setAttribute("user",new User("ggg",2));
        return  "study";
    }
}
