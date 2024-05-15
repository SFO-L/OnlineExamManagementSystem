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
import jakarta.servlet.jsp.JspWriter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ExamServlet", value = "/ExamServlet")
public class ExamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        PrintWriter writer = response.getWriter();



        //获取考试题目信息
        List<Question> questionrand = (List<Question>)session.getAttribute("questionrand");
        PrintWriter out;
        out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");

        int score = 0;
        //获取答案和考生答案
        for(Question q : questionrand){
            String answer = q.getAnswer();

            Integer questionId = q.getQuestionId();
            String parameter = request.getParameter("answer_" + questionId);
            if(parameter == null){
                out.println("<font style='color:red;font-size:40'> 未完成答题</font>");
                return;
            }
            if (parameter.equals(answer)) {
                score += 25;
            }

        }

        request.setAttribute("score","本次考试成绩"+score);
        request.getRequestDispatcher("Question/score.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
