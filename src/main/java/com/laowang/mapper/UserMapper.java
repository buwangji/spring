package com.laowang.mapper;

import com.laowang.pojo.User;

/**
 * Created by Administrator on 2017/1/10.
 */
public interface UserMapper {
    void save(User user);
    User findById(Integer id);
}
