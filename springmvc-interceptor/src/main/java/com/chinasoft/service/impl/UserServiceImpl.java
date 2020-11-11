package com.chinasoft.service.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao ud;

    public void setUd(UserDao ud) {
        this.ud = ud;
    }

    @Override
    public User login(String username, String password) {
        try {
            return ud.checkLogin(username,password);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
