package com.springboot.chatpter04_demonewbook;


import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before.....");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after......");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException {
        System.out.println("around  before......" );
        Object obj = null;
        obj = invocation.proceed();
        System.out.println("around  after......" );
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("after returning...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("after throwing....." );
    }

    @Override
    public boolean useAround() {
        return false;
    }
}
