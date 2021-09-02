package com.kuang.demo01.service;

public class UserServiceImpl implements UserService{

    @Override
    public int add() {
        System.out.println("增加一个用户");
        return 0;
    }

    @Override
    public int update() {
        System.out.println("修改一个用户");
        return 0;
    }

    @Override
    public int query() {
        System.out.println("查询一个用户");
        return 0;
    }

    @Override
    public int delete() {
        System.out.println("删除一个用户");
        return 0;
    }
}
