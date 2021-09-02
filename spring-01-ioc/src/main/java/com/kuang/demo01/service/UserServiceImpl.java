package com.kuang.demo01.service;

import com.kuang.dao.UserDao;

public class UserServiceImpl implements UserService {

    //新增加了UserDaoMysql,只能改变原来的类,会因为用户的需求改变原有的业务代码，适应不了用户的变更
    //private UserDao userDao = new UserDaoImpl();
    private UserDao userDao;

    //增加set方法，利用set实现动态实现值的输入
    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
