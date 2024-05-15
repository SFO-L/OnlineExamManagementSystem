package com.sys.controller.Question; /**
 * @Author SfO
 * @Version 1.0
 */

import com.sys.entity.Question;
import com.sys.entity.Users;
import com.sys.factory.QuestionFactory;
import com.sys.factory.UserFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FindQuestionByIdServlet", value = "/FindQuestionByIdServlet")
public class FindQuestionByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String questionId = request.getParameter("QuestionId");
            Question byId = QuestionFactory.getQuestionDao().findById(questionId);
            request.setAttribute("QueInfoById",byId);
            request.getRequestDispatcher("Question/question_Update.jsp").forward(request,response);

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
