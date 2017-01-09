package com.laowang.test;

import com.laowang.dao.impl.UserDaoImpl;
import com.laowang.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestCase {
    @Test
    public void aaa(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
       /* UserDaoImpl userDao =
                (UserDaoImpl) applicationContext.getBean("UserDaoImpl");
        userDao.add();
        userDao.save();
*/
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
        userService.getNum();
    }

}
