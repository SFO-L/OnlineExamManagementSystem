package com.sys.controller.Question;

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
import java.sql.SQLException;

/**
 * @Author SfO
 * @Version 1.0
 */



@WebServlet(name = "QuestionUpDateServlet", value = "/QuestionUpDateServlet")
public class QuestionUpDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title,optionA,optionB,optionC,optionD,answer;
        Integer qusetionId = Integer.parseInt(request.getParameter("questionId"));
        title = request.getParameter("title");
        optionA = request.getParameter("optionA");
        optionB= request.getParameter("optionB");
        optionC= request.getParameter("optionC");
        optionD= request.getParameter("optionD");
        answer = request.getParameter("answer");

        Question question = new Question(qusetionId,title,optionA,optionB,optionC,optionD,answer);

        try {
            boolean b = QuestionFactory.getQuestionDao().updateQuestion(question);

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out;
            out = response.getWriter();
            if(b){
                out.println("<font style='color:red;font-size:40'> 修改成功</font>");
            }else {
                out.println("<font style='color:red;font-size:40'> 修改失败</font>");
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
