package com.kuang.demo02;

public class UserServiceProxy implements UserService{

    UserServiceImpl userService = new UserServiceImpl();

    public UserServiceProxy() {
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    //日志
    public void log(String msg) {
        System.out.println("[INFO]使用了" + msg + "方法");
    }
}
