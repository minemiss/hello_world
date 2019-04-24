package com.springboot.chatpter04_demonewbook;

public interface Interceptor {
    public boolean before();
    public void after();
    public Object around(Invocation invocation)
            throws Throwable;

    public void afterReturning();
    public void afterThrowing();
    boolean useAround();


}
