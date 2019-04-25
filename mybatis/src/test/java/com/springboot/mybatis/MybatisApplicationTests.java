package com.springboot.mybatis;

import com.springboot.mybatis.Service.MyBatisUserServiceImpl;
import com.springboot.mybatis.Service.MybatisUserService;
import com.springboot.mybatis.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisApplicationTests {
    @Autowired
    private MybatisUserService mybatisUserService = null;

    public Long id = 1L;
    public User test(){
            return mybatisUserService.getUser(id);
    }

    @Test
    public void contextLoads() {
        User user = test();
        System.out.println(user.getId()+" "+user.getNote()+"    "+user.getUser_name());
    }

}
