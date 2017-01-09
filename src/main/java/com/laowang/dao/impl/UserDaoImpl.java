package com.laowang.dao.impl;

import com.laowang.dao.UserDao;

/**
 * Created by Administrator on 2017/1/7.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("二货航");
    }

    @Override
    public void save() {
        System.out.println("逗比航");
    }
    public UserDaoImpl(){
        System.out.println("这是测试");
    }


}
