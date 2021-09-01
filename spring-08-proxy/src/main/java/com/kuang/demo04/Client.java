package com.kuang.demo04;

import com.kuang.demo02.UserService;
import com.kuang.demo02.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        //真实角色,都得有
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //1.代理一个接口,真实对象
        //代理角色通过handler实现
        //设置要代理的对象
        handler.setTarget(userService);
        //2.动态生成代理类
        //代理角色通过handler创建出来的
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
        proxy.delete();
        proxy.query();
        proxy.update();
    }
}
