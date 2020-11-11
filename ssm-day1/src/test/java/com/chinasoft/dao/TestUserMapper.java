package com.chinasoft.dao;

import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserMapper {
    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void test(){
        User u = userService.selectByUsernameAndPassword(new User("wj", "123"));
        System.out.println(u);
    }
}
