package com.laowang.service;

import com.laowang.pojo.User;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface UserService {

    void save(User user) throws Exception;
    User findById(Integer id);

}
