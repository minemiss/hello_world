package com.springboot.chatpter02_demonewbook;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceShow implements ApplicationContextAware {

    ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(dataSource.getClass().getName());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
    }
}
