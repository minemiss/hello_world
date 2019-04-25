package com.springboot.mybatisweb;

import com.springboot.mybatisweb.dao.MyBatisUserDao;
import com.springboot.mybatisweb.domain.SexEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybatiswebApplication {
    @Autowired
    SqlSessionFactory sqlSessionFactory = null;

    @Bean
    public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao(){
        MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
        bean.setMapperInterface(MyBatisUserDao.class);
        bean.setSqlSessionFactory(sqlSessionFactory);
        TypeHandler<SexEnum> sexTypeHandler = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry().getTypeHandler(SexEnum.class);
        return bean;

    }

    public static void main(String[] args) {
        SpringApplication.run(MybatiswebApplication.class, args);
    }

}
