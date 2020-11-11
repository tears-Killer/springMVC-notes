package com.chinasoft.controller;

import com.chinasoft.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies==null){
            return "login";
        }else {
            User u = (User) request.getSession().getAttribute("user_info");
            for (Cookie c:cookies){
                if (c.getName().equals(u.getUsername())){
                    return "redirect:/home";
                }
            }
        }
        return "login";
    }

    @RequestMapping(value = "/checklogin")
    public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpServletRequest request, HttpSession session,HttpServletResponse response){
        if(username.equals("wj") && password.equals("123")){
            session.setAttribute("user_info",new User(username,password));
            request.getServletContext().setAttribute(username,session.getId());
            Cookie loginCookie = new Cookie(username,username);
            loginCookie.setMaxAge(10);
            response.addCookie(loginCookie);
            return "redirect:/home";
        }else{
            return "login";
        }
    }

}
