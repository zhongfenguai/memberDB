package com.member.servlet;

import com.google.gson.Gson;
import com.member.entity.User;
import com.member.service.UserService;
import com.member.service.impl.UserServiceImpl;
import com.member.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：chenbingfeng
 * 日期: 2020/12/1 17:39
 * 描述:
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

    }

    public void queryPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer pageNo = Integer.parseInt(request.getParameter("pageNo"));
        Page<User> page = userService.queryByPage(pageNo, Page.PAGE_SIZE);
        Gson gson = new Gson();
        String JSONstr = gson.toJson(page);
        response.getWriter().write(JSONstr);

    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Long userid = Long.valueOf(request.getParameter("userId"));
        Integer result = userService.delete(userid);
        System.out.println(result);
        response.getWriter().write(result.toString());

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userService.login(user);
        if (user1 == null) {
            response.getWriter().write("false");
//            response.sendRedirect("/login.html");

        } else {
            //登录成功
            response.getWriter().write("true");
            request.getSession().setAttribute("user", user1);
        }


    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/member/login.html");



    }
}
