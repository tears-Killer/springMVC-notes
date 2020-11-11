package com.chinasoft.dao.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User checkLogin(String username,String password) throws EmptyResultDataAccessException {
        User u = jdbcTemplate.queryForObject("select * from user where username = ? and password = ?",
                new BeanPropertyRowMapper<User>(User.class),username,password);
        return u;
    }
}
