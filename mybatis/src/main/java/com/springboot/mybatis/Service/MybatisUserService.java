package com.springboot.mybatis.Service;
import com.springboot.mybatis.domain.User;
import org.springframework.stereotype.Service;


public interface MybatisUserService {
    public User getUser(Long id );
}
