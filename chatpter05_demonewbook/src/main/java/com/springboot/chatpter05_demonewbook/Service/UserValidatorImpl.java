package com.springboot.chatpter05_demonewbook.Service;

import com.springboot.chatpter05_demonewbook.domain.User;

public class UserValidatorImpl implements  UserValidator{
    @Override
    public boolean validator(User user) {
        System.out.println("引入新的接口："+UserValidator.class.getSimpleName());
        return user!=null;
    }
}
