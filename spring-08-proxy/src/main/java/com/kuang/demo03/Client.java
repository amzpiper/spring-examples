package com.kuang.demo03;

public class Client {

    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象
        //真实角色实现了Rent接口，代理角色还没实现
        //代理角色通过handler实现
        handler.setRent(host);
        //代理角色通过handler创建出来的
        Rent proxy = (Rent) handler.getProxy();
        proxy.rent();

    }
}
