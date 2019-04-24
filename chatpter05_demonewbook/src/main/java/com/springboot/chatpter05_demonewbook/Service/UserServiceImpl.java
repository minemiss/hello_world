package com.springboot.chatpter05_demonewbook.Service;

import com.springboot.chatpter05_demonewbook.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        System.out.println("这是老的接口");
        if (user == null){
            throw new RuntimeException("user is null");
        }
        System.out.println("id=" + user.getId());
        System.out.println("\tusername = "+user.getUsername());
        System.out.println("\tnote = "+ user.getNote());
    }
}
