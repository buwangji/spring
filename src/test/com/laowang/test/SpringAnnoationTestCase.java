package com.laowang.test;

import com.laowang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/1/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
//@ContextConfiguration(classes = Application.class)
public class SpringAnnoationTestCase {
    @Autowired
    private UserService userService;
    @Test
    public void save(){
        userService.save();
    }

}
