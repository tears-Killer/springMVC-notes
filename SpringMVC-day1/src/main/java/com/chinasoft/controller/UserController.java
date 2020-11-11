package com.chinasoft.controller;

import com.chinasoft.domain.User;
import com.chinasoft.domain.UserList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.Oneway;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

//    携带参数必须含有username
    @RequestMapping(value = "/login",method =  RequestMethod.GET,params = {"username"})
    public String login(){
        //转发
//        return "index";
        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/checklogin")
    public ModelAndView checklogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","wj");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/checklogin1")
    public ModelAndView checklogin1(ModelAndView modelAndView){
        modelAndView.addObject("username","wj");
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping(value = "/checklogin2")
    public String checklogin2(Model model){
    model.addAttribute("username","wj");
        return "index";
    }

//    直接返回数据 不跳转 localhost:8080/user/checklogin3/wzx
    @RequestMapping(value = "/checklogin3/{name}")
    @ResponseBody
    public String checklogin2(@PathVariable("name") String username){
        return username;
    }

    @RequestMapping(value = "/checklogin4")
    @ResponseBody
    public String checklogin4() throws JsonProcessingException {
        User u = new User();
        u.setUsername("wzx");
        u.setAge(22);
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(u);
        return json;
    }

    @RequestMapping(value = "/checklogin5")
    @ResponseBody
    public User checklogin5(){
        User u = new User();
        u.setUsername("wzx");
        u.setAge(22);
        return u;
    }

    @RequestMapping(value = "/checklogin6")
    @ResponseBody
    public void checklogin6(UserList ul){
        System.out.println(ul);
    }

    @RequestMapping(value = "/checklogin7")
    @ResponseBody
    public void checklogin7(@RequestBody List<User> ulist){
        System.out.println(ulist);
    }

    //    获取请求头
    @RequestMapping(value = "/checklogin8")
    @ResponseBody
    public void checklogin8(@RequestHeader("User-Agent") String user_agent){
        System.out.println(user_agent);
    }

    //    获取cookie id
    @RequestMapping(value = "/checklogin9")
    @ResponseBody
    public void checklogin9(@CookieValue("JESSIONID") String jessionid){
    System.out.println(jessionid);
        }
    }
