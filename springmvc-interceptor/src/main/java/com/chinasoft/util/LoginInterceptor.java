package com.chinasoft.util;

import com.chinasoft.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        User u = (User) request.getSession().getAttribute("user_info");
        if(u!=null){
            String sid = request.getSession().getId();
            String aid = (String) request.getServletContext().getAttribute(u.getUsername());
            if(sid.equals(aid)){
                return true;
            }else{
                request.getSession().removeAttribute("user_info");
                request.getSession().invalidate();
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().print("<html><body>");
                response.getWriter().print("<script>alert('异地登录 被迫下线');window.location.href='/login.jsp';</script>");
                response.getWriter().print("</html></body>");
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
