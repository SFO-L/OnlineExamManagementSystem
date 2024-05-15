package com.sys.Dao;

import com.sys.entity.Question;
import com.sys.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author SfO
 * @Version 1.0
 */
public class QuestionDaoImp implements QuestionDao{
    private Connection conn;
    private PreparedStatement pstm;

    public QuestionDaoImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean add(Question question) throws SQLException {
        boolean flag = false;
        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        this.pstm = this.conn.prepareStatement(sql);
        //为sql预设变量添加值
        this.pstm.setString(1,question.getTitle());
        this.pstm.setString(2,question.getOptionA());
        this.pstm.setString(3,question.getOptionB());
        this.pstm.setString(4,question.getOptionC());
        this.pstm.setString(5,question.getOptionD());
        this.pstm.setString(6,question.getAnswer());

        //进行插入操作  并判断是否成功
        if(this.pstm.executeUpdate() > 0){
            flag = true;
        }
        this.pstm.close();
        return flag;
    }

    @Override
    public List<Question> findAll() throws SQLException {
        //Question集合
        List<Question> list = new ArrayList<>();
        //查询语句
        String sql = "select  * from question where state = '1'";
        //数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        ResultSet resultSet = this.pstm.executeQuery();

        while (resultSet.next()){
            Question question = new Question();
            question.setQuestionId(resultSet.getInt(1));
            question.setTitle(resultSet.getString(2));
            question.setOptionA(resultSet.getString(3));
            question.setOptionB(resultSet.getString(4));
            question.setOptionC(resultSet.getString(5));
            question.setOptionD(resultSet.getString(6));
            question.setAnswer(resultSet.getString(7));
            list.add(question);
        }
        this.pstm.close();
        return list;
    }

    @Override
    public boolean delete(String questionId) throws SQLException {
        boolean flag = false;
        String sql = "update question set state = 0 where questionId =?";
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,questionId);
        int i = this.pstm.executeUpdate();
        if(i > 0){
            flag =true;
        }
        this.pstm.close();
        return flag;
    }

    @Override
    public Question findById(String questionId) throws SQLException {
        Question question = new Question();
        String sql = "select * from question where questionId = ?";
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,questionId);
        ResultSet resultSet = this.pstm.executeQuery();
        while (resultSet.next()){
            question.setQuestionId(resultSet.getInt(1));
            question.setTitle(resultSet.getString(2));
            question.setOptionA(resultSet.getString(3));
            question.setOptionB(resultSet.getString(4));
            question.setOptionC(resultSet.getString(5));
            question.setOptionD(resultSet.getString(6));
            question.setAnswer(resultSet.getString(7));
        }
        return question;
    }

    @Override
    public boolean updateQuestion(Question question) throws SQLException {
        boolean flag = false;
        String sql = "update question set title = ? ,optionA =?,optionB =? ,optionC = ?,optionD = ? ,answer = ?where questionId = ?";
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,question.getTitle());
        this.pstm.setString(2,question.getOptionA());
        this.pstm.setString(3,question.getOptionB());
        this.pstm.setString(4,question.getOptionC());
        this.pstm.setString(5,question.getOptionD());
        this.pstm.setString(6,question.getAnswer());
        this.pstm.setInt(7,question.getQuestionId());

        int i = this.pstm.executeUpdate();
        if(i > 0){
            flag = true;
        }
        this.pstm.close();
        return flag;
    }

    @Override
    public List<Question> findRand() throws SQLException {
        //Question集合
        List<Question> list = new ArrayList<>();
        //查询语句
        String sql = "select * from question order by rand() limit 0,4";
        //数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        ResultSet resultSet = this.pstm.executeQuery();

        while (resultSet.next()){
            Question question = new Question();
            question.setQuestionId(resultSet.getInt(1));
            question.setTitle(resultSet.getString(2));
            question.setOptionA(resultSet.getString(3));
            question.setOptionB(resultSet.getString(4));
            question.setOptionC(resultSet.getString(5));
            question.setOptionD(resultSet.getString(6));
            question.setAnswer(resultSet.getString(7));
            list.add(question);
        }
        this.pstm.close();
        return list;
    }
}
