package com.sys.controller.User; /**
 * @Author SfO
 * @Version 1.0
 */

import com.sys.entity.Users;
import com.sys.factory.UserFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "UserFindAllServlet", value = "/UserFindAllServlet")
public class UserFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Users> findall = UserFactory.getUserDao().findall();

            request.setAttribute("UserFindall",findall);

            request.getRequestDispatcher("User/user_FindAll.jsp").forward(request,response);


        }  catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
