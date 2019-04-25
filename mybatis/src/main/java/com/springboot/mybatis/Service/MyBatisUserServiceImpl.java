package com.springboot.mybatis.Service;

import com.springboot.mybatis.dao.MyBatisUserDao;
import com.springboot.mybatis.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyBatisUserServiceImpl implements MybatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;
    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
