package com.chinasoft.dao;

import com.chinasoft.pojo.User;

public interface UserMapper {
    User selectByUsernameAndPassword(User user);
}
