package com.sys.controller.User;

import com.sys.entity.Users;
import com.sys.factory.UserFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * @Author SfO
 * @Version 1.0
 */



@WebServlet(name = "UpDateServlet", value = "/UpDateServlet")
public class UpDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email,password,username,sex,oldpassword;
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();

        email = (String) session.getAttribute("email");
        password = request.getParameter("password");
        username = request.getParameter("userName");
        sex = request.getParameter("sex");
        oldpassword =request.getParameter("oldpassword");

        Users users = new Users();
        users.setEmail(email);
        users.setPassword(password);
        users.setSex(sex);
        users.setUserName(username);


        try {
            boolean flag = UserFactory.getUserDao().update(users, oldpassword);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out;
            out = response.getWriter();
            if(flag){
                out.println("<font style='color:red;font-size:40'> 修改成功</font>");
            }else {
                out.println("<font style='color:red;font-size:40'> 修改失败</font>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
