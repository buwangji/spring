package com.laowang.service.impl;

import com.laowang.dao.UserDao;
import com.laowang.service.UserService;

/**
 * Created by Administrator on 2017/1/9.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save() {
        userDao.save();
    }

    @Override
    public int getNum() {
        System.out.println("getNum~~~~~~~~~~~~");
        return 100;
    }
}
