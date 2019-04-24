package com.springboot.chatpter04_demonewbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chatpter04DemonewbookApplicationTests {

    @Test
    public void contextLoads() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());
        proxy.sayHello("aaaa");
        System.out.println("....................name is null......................");
        proxy.sayHello(null);


        }
    }
