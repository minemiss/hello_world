package com.springboot.mybatis.dao;

import org.springframework.stereotype.Repository;
import com.springboot.mybatis.domain.User;
@Repository
public interface MyBatisUserDao {
    public  User getUser(Long id);
}
