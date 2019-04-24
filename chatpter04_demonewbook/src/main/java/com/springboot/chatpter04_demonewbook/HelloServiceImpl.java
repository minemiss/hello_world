package com.springboot.chatpter04_demonewbook;

public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        if (name==null||name.trim()==""){
            throw new RuntimeException("is null");
        }
        System.out.println(name);
    }


}
