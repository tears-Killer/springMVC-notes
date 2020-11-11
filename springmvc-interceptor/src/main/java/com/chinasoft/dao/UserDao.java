package com.chinasoft.dao;

import com.chinasoft.pojo.User;

public interface UserDao {
    public User checkLogin(String username,String password);
}
