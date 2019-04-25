package com.springboot.mybatisweb.dao;

import com.springboot.mybatisweb.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
    public  User getUser(Long id);
}
