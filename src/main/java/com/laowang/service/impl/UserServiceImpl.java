package com.laowang.service.impl;

import com.laowang.dao.UserDao;
import com.laowang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/1/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save() {

    }

    @Override
    public int getNum() {
        System.out.println("getNum~~~~~~~~~~~~");
        return 100;
    }
}
