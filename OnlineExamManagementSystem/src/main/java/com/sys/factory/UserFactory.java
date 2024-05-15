package com.sys.factory;

import com.sys.Dao.UserDao;
import com.sys.entity.Users;
import com.sys.service.UserDaoService;

import java.sql.SQLException;

/**
 * @Author SfO
 * @Version 1.0
 */
public class UserFactory  {
    public static UserDao getUserDao() throws SQLException, ClassNotFoundException {
        return new UserDaoService();
    }
}
