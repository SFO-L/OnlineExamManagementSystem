package com.sys.controller.Question; /**
 * @Author SfO
 * @Version 1.0
 */

import com.sys.entity.Question;
import com.sys.factory.QuestionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionRandServlet", value = "/QuestionRandServlet")
public class QuestionRandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //调用dao随机拿出4题
            List<Question> rand = QuestionFactory.getQuestionDao().findRand();
            //通过session变成共享数据
            HttpSession session = request.getSession(false);
            session.setAttribute("questionrand",rand);

            //转发到exam.jsp
            request.getRequestDispatcher("Question/exam.jsp").forward(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
