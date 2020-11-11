package com.chinasoft.service;

import com.chinasoft.pojo.User;

public interface UserService {

    User selectByUsernameAndPassword(User user);
}
