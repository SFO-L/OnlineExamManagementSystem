package com.sys.controller;

import com.sys.factory.UserFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @Author SfO
 * @Version 1.0
 */



@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email,password;
        //请求对象用utf方式重写编写请求数据
        request.setCharacterEncoding("utf-8");
        //读取请求参数
        email = request.getParameter("email");
        password = request.getParameter("password");
        //用dao调用数据库验证
        try {
            boolean login = UserFactory.getUserDao().login(email, password);
            //登录失败
            if(login == false){
                response.sendRedirect(request.getContextPath()+"/myjsp/logerror.jsp");
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("email",email);
            session.setAttribute("loginFlag","Yes");
            //分权限
            int quanx = UserFactory.getUserDao().quanx(email);
            session.setAttribute("quanxian",quanx);
            response.sendRedirect(request.getContextPath()+"/myjsp/index.jsp");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
