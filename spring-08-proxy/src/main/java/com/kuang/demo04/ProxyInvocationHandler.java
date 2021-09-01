package com.kuang.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//等我们会用着了类，自动生成代理类。
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生产得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    //处理代理实例，并返回结构
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的本质是反射
        log(method.getName());
        Object invoke = method.invoke(target, args);

        return invoke;
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");
    }
}
