package com.laowang.dao.impl;

import com.laowang.dao.UserDao;
import com.laowang.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void save() throws Exception {
        User user = new User("阿航","123");
        userDao.save(user);
    }

    @Test
    public void update() throws Exception {
        User user = userDao.findById(3);
        user.setName("2航");
        userDao.update(user);
    }

    @Test
    public void findById() throws Exception {
        User user = userDao.findById(3);
        System.out.println(user);
        assertNotNull(user);
    }

    @Test
    public void findAll() throws Exception {
        List<User> userList = userDao.findAll();
        for(User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void count() throws Exception {
        Long result = userDao.count();
        System.out.println(result);
    }

}