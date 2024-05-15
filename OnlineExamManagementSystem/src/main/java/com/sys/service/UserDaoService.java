package com.sys.service;

import com.sys.Dao.UserDao;
import com.sys.Dao.UserDaoImp;
import com.sys.db.DBconnection;
import com.sys.db.JDBCUtilsDruid;
import com.sys.entity.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author SfO
 * @Version 1.0
 */
public class UserDaoService implements UserDao {
    private UserDao userDao;
    private Connection con;

    public UserDaoService() throws SQLException, ClassNotFoundException {
        con = JDBCUtilsDruid.getConnection();
        this.userDao = new UserDaoImp(con);
    }

    @Override
    public boolean add(Users users) throws Exception {
        boolean flag = false;
        //判断邮箱是否存在
        if(emailexist(users.getEmail())){
            System.out.println("邮箱重复");
            return flag;
        }
        if(users != null){
            flag = userDao.add(users);
        }
        this.con.close();
        return flag;
    }

    @Override
    public List<Users> findall() throws Exception {
        List<Users> findall = userDao.findall();
        this.con.close();
        return findall;
    }

    //查找个人信息
    @Override
    public Users findself(String email) throws Exception {
        Users findself = userDao.findself(email);
        this.con.close();
        return findself;
    }

    @Override
    public boolean emailexist(String email) throws SQLException {
        boolean flag = userDao.emailexist(email);
        return flag;
    }

    @Override
    public boolean delete(String userId) throws Exception {
        boolean flag = userDao.delete(userId);
        this.con.close();
        return flag;
    }

    @Override
    public boolean login(String email, String password) throws Exception {
        boolean flag = userDao.login(email,password);
        this.con.close();
        return flag;
    }

    @Override
    public int quanx(String email) throws SQLException {
        int quanx = userDao.quanx(email);
        return quanx;
    }

    //修改用户信息
    @Override
    public boolean update(Users users, String oldpassword) throws SQLException {
        boolean flag = false;
        if(users!=null) {
            flag = userDao.update(users, oldpassword);
        }
        return flag;
    }
}
