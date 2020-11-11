package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request, HttpSession session){
        if(username.equals("wj") && password.equals("123")){
            session.setAttribute("user_info",new User(username,password));
            request.getServletContext().setAttribute(username,session.getId());
            return "index.jsp";
        }else{
         return "login.jsp";
        }
    }

    @RequestMapping(value = "/aaa")
    public String test(){
        return "success.jsp";
    }

    @RequestMapping(value = "/bbb")
    public String test1(){
        return "success.jsp";
    }

    @RequestMapping(value = "/ccc")
    public String test2(){
        return "success.jsp";
    }
}
