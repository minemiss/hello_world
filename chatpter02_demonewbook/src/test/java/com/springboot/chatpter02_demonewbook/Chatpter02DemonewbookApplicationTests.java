package com.springboot.chatpter02_demonewbook;

import com.springboot.chatpter02_demonewbook.JPA.JpaUserRespository;
import com.springboot.chatpter02_demonewbook.JPA.User;
import com.springboot.chatpter02_demonewbook.jdbctemp.JdbcTmpUserServiceImpl;
import com.springboot.chatpter02_demonewbook.jdbctemp.SexEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chatpter02DemonewbookApplicationTests {

    @Autowired
    private JpaUserRespository jpaUserRespository = null;

    @Test
    public void contextLoads() {

        Long id = 1L;


        User user = jpaUserRespository.findById(id).get();
        System.out.println(user.getId());
        System.out.println(user.getSex());
        System.out.println(user.getUserName());
        System.out.println(user.getNote());


      /*  Long i = 2L;

        JdbcTmpUserServiceImpl jdbcTmpUserService = new JdbcTmpUserServiceImpl();
        System.out.println(jdbcTmpUserService.getUser(i));*/
    }

}
