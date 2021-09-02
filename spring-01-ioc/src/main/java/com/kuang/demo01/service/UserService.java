package com.kuang.demo01.service;

import com.kuang.dao.UserDao;

public interface UserService {
    void getUser();

    void setUserDao(UserDao userDao);
}
