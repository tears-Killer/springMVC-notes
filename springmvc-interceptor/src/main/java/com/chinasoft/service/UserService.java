package com.chinasoft.service;

import com.chinasoft.pojo.User;

public interface UserService {
    public User login(String username, String password);
}
