package com.sys.controller.User; /**
 * @Author SfO
 * @Version 1.0
 */

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
import java.util.List;

@WebServlet(name = "UserFindSelfServlet", value = "/UserFindSelfServlet")
public class UserFindSelfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            String email = (String)session.getAttribute("email");
            Users s = UserFactory.getUserDao().findself(email);

            request.setAttribute("UserFindSelf",s);

            request.getRequestDispatcher("User/user_FindSelf.jsp").forward(request,response);



        }  catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
