package com.member.filter;

import  com.member.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/2 20:24
 * 描述:
 */
@WebFilter("/admin/userList.html")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        //如果user为空
        if(user==null){
            response.sendRedirect("/member/login.html");
        }else {
            chain.doFilter(req,resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
