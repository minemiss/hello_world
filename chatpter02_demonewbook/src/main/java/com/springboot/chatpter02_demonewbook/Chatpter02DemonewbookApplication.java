package com.springboot.chatpter02_demonewbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.springboot.chatpter02_demonewbook"})
@EnableJpaRepositories(basePackages = "com.springboot.chatpter02_demonewbook")
@EntityScan(basePackages = "com.springboot.chatpter02_demonewbook")
public class Chatpter02DemonewbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chatpter02DemonewbookApplication.class, args);
    }

}
