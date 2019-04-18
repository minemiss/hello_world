package com.spring.chatpter01_demonewbook;

import org.springframework.beans.factory.annotation.Autowired;

public class User  {

    public String name;
    public  int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name , int age) {
        this.name = name;
        this.age = age;
    }
}
