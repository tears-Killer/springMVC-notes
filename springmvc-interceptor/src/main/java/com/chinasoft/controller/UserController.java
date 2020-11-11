package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import com.chinasoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService us;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
       User u = us.login(username, password);
        System.out.println(u);

        if(u == null){
            return "redirect:/login.jsp";
        }
        session.setAttribute("user",u);
        return "redirect:/index.jsp";
    }
}
