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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QuestionFindAllServlet", value = "/QuestionFindAllServlet")
public class QuestionFindAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Question> findall = QuestionFactory.getQuestionDao().findAll();

            request.setAttribute("questionList",findall);

            request.getRequestDispatcher("Question/QuestionShow.jsp").forward(request,response);

        }  catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
