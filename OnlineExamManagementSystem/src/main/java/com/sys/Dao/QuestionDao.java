package com.sys.Dao;

import com.sys.entity.Question;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author SfO
 * @Version 1.0
 */
public interface QuestionDao {
    //添加试题
    public boolean add(Question question) throws Exception;

    public List<Question> findAll() throws Exception;

    public boolean delete(String questionId) throws Exception;

    public Question findById(String questionId) throws Exception;

    public boolean updateQuestion(Question question) throws Exception;
    public List<Question> findRand() throws Exception;
}
