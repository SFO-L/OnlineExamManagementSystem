package com.sys.controller.User; /**
 * @Author SfO
 * @Version 1.0
 */

import com.sys.entity.Users;
import com.sys.factory.UserFactory;
import com.sys.service.UserDaoService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "UserAddServlet", value = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //读取请求信息
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");

        System.out.println(sex.length());
        Users users = new Users(userName, password,email,sex);
        //调用UserDao插入数据
        try {
            boolean flag = UserFactory.getUserDao().add(users);

            //调用响应对象，返回结果
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out;
            out = response.getWriter();
            if(flag){
                out.println("<font style='color:red;font-size:40'> 注册成功</font>");
            }else {
                out.println("<font style='color:red;font-size:40'> 注册失败</font>");
            }
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    //tomcat负责销毁请求响应对象
    //tomcat负责将http响应包放回浏览器
    //浏览器解析展示


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
