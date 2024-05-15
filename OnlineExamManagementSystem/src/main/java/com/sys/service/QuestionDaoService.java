package com.sys.service;

import com.alibaba.druid.util.JdbcUtils;
import com.sys.Dao.QuestionDao;
import com.sys.Dao.QuestionDaoImp;
import com.sys.Dao.UserDao;
import com.sys.Dao.UserDaoImp;
import com.sys.db.DBconnection;
import com.sys.db.JDBCUtilsDruid;
import com.sys.entity.Question;
import com.sys.entity.Users;
import jakarta.servlet.ServletContext;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author SfO
 * @Version 1.0
 */
public class QuestionDaoService implements QuestionDao {
    private Connection con;
    private QuestionDao questionDao;
    public QuestionDaoService() throws SQLException, ClassNotFoundException {
        this.con = JDBCUtilsDruid.getConnection();
        this.questionDao = new QuestionDaoImp(con);
    }
    @Override
    public boolean add(Question question) throws Exception {
        boolean flag = false;

        if(question != null){
            flag = questionDao.add(question);
        }
        this.con.close();
        return flag;
    }

    @Override
    public List<Question> findAll() throws Exception {
        List<Question> findall = questionDao.findAll();
        this.con.close();
        return findall;
    }

    @Override
    public boolean delete(String questionId) throws Exception {
        boolean flag = questionDao.delete(questionId);
        this.con.close();
        return flag;
    }

    @Override
    public Question findById(String questionId) throws Exception {
        Question question = questionDao.findById(questionId);
        this.con.close();
        return question;
    }

    @Override
    public boolean updateQuestion(Question question) throws Exception {
        boolean falg = questionDao.updateQuestion(question);
        this.con.close();
        return falg;
    }

    @Override
    public List<Question> findRand() throws Exception {
        List<Question> findall = questionDao.findRand();
        this.con.close();
        return findall;
    }
}
