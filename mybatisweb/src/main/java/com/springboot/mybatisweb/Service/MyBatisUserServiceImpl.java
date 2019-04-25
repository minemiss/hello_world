package com.springboot.mybatisweb.Service;

import com.springboot.mybatisweb.dao.MyBatisUserDao;
import com.springboot.mybatisweb.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBatisUserServiceImpl implements MybatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao = null;
    @Override
    public User getUser(Long id) {
        return myBatisUserDao.getUser(id);
    }
}
