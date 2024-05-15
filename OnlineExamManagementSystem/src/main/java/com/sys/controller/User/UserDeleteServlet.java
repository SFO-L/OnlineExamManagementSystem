package com.sys.controller.User; /**
 * @Author SfO
 * @Version 1.0
 */

import com.sys.factory.UserFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        try {
            boolean delete = UserFactory.getUserDao().delete(userId);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out;
            out = response.getWriter();
            if(delete){
                out.println("<font style='color:red;font-size:40'> 注销成功</font>");
            }else {
                out.println("<font style='color:red;font-size:40'> 注销失败</font>");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
