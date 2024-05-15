package com.sys.factory;

import com.sys.Dao.QuestionDao;
import com.sys.Dao.QuestionDaoImp;
import com.sys.service.QuestionDaoService;

import java.sql.SQLException;

/**
 * @Author SfO
 * @Version 1.0
 */
public class QuestionFactory {
    public static QuestionDao getQuestionDao() throws SQLException, ClassNotFoundException {
        return new QuestionDaoService();
    }
}
