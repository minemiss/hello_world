package com.springboot.chatpter05_demonewbook.Aspect;

import com.springboot.chatpter05_demonewbook.Service.UserValidator;
import com.springboot.chatpter05_demonewbook.Service.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspect {

    @Pointcut("execution(* com.springboot.chatpter05_demonewbook.Service.UserServiceImpl.printUser(..))")
    public void pointcut(){};

    @Before("pointcut()")
    public void before(){
        System.out.println("before............");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after.........");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(){
        System.out.println("afterReturning...........");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing(){
        System.out.println("afterThrowing............");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("around before");
        jp.proceed();
        System.out.println("around after");
    }

    @DeclareParents(
            value = "com.springboot.chatpter05_demonewbook.Service.UserServiceImpl+" , defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

}
