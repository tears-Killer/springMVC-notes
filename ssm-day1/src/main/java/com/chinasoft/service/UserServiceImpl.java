package com.chinasoft.service;

import com.chinasoft.dao.UserMapper;
import com.chinasoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User selectByUsernameAndPassword(User user) {
        return userMapper.selectByUsernameAndPassword(user);
    }
}
