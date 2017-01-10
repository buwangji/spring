package com.laowang.dao;


import com.laowang.pojo.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    void update(User user);
    User findById(Integer id);
    List<User> findAll();
    Long count();


}
