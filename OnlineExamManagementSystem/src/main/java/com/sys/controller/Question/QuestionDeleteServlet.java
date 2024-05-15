package com.sys.controller.Question; /**
 * @Author SfO
 * @Version 1.0
 */

import com.sys.entity.Question;
import com.sys.factory.QuestionFactory;
import com.sys.factory.UserFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestionDeleteServlet", value = "/QuestionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String questionId = request.getParameter("QuestionId");
        try {
            boolean delete = QuestionFactory.getQuestionDao().delete(questionId);
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
