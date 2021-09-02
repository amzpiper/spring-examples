package com.kuang.demo01.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {

    //returnValue返回值，因为执行后可以有返回值
    //method要执行的目标对象的方法
    //objects:参数
    //o:目标对象
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"类执行了"+method.getName()+"方法，返回结果为："+returnValue);
    }
}
