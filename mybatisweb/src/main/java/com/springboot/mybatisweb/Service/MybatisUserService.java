package com.springboot.mybatisweb.Service;
import com.springboot.mybatisweb.domain.User;


public interface MybatisUserService {
    public User getUser(Long id);
}
