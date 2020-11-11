package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import com.chinasoft.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private  UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login")
    public String checklogin(User user, HttpSession session){
        User u = userService.selectByUsernameAndPassword(user);
        session.setAttribute("user",u);
        BookController bc = new BookController();
        return "redirect: /ssm_day1/book/getAllBook";
    }
}
