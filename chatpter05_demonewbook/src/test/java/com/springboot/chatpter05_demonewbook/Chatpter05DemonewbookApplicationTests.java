package com.springboot.chatpter05_demonewbook;

import com.springboot.chatpter05_demonewbook.Service.UserService;
import com.springboot.chatpter05_demonewbook.Service.UserServiceImpl;
import com.springboot.chatpter05_demonewbook.Service.UserValidator;
import com.springboot.chatpter05_demonewbook.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chatpter05DemonewbookApplicationTests {


    @Autowired
    private UserService userService = null;

    public User test(){
       User user = new User();
       /* User user =null;*/
        user.setId(1);
        user.setUsername("a");
        user.setNote("aa");
        UserValidator userValidator = (UserValidator) userService;
        if (userValidator.validator(user)){
            userService.printUser(user);
        }else{
            System.out.println("false");
        }
        return  user;
    }

    @Test
    public void contextLoads() {
       test();
    }

}
