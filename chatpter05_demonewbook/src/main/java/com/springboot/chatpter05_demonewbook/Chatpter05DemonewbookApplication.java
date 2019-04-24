package com.springboot.chatpter05_demonewbook;

import com.springboot.chatpter05_demonewbook.Aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chatpter05DemonewbookApplication {

    @Bean
    public MyAspect initMyAspect(){
        return  new MyAspect();
    }

    public static void main(String[] args) {
        SpringApplication.run(Chatpter05DemonewbookApplication.class, args);
    }

}
