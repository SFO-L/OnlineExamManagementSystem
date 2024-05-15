package com.sys.Dao;

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
public class UserDaoImp implements UserDao{
    private Connection conn;

    private PreparedStatement pstm;

    public UserDaoImp(Connection conn) {
        this.conn = conn;
    }

    //添加用户信息
    public boolean add(Users users) throws SQLException {
        boolean flag = false;
        //add的sql
        String sql = "insert into users(userName,password,sex,email) values(?,?,?,?)";
        //参加数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        //为sql预设变量添加值
        this.pstm.setString(1,users.getUserName());
        this.pstm.setString(2,users.getPassword());
        this.pstm.setString(3,users.getSex());
        this.pstm.setString(4,users.getEmail());

        //进行插入操作  并判断是否成功
        if(this.pstm.executeUpdate() > 0){
            flag = true;
        }
        this.pstm.close();
        return flag;
    }

    //查询所有用户信息
    @Override
    public List<Users> findall() throws SQLException {
         //Users集合
        List<Users> list = new ArrayList<>();
        //查询语句
        String sql = "select  * from users where state = '1'";
        //数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        ResultSet resultSet = this.pstm.executeQuery();

        while (resultSet.next()){
            Users users = new Users();
            users.setUserId(resultSet.getInt(1));
            users.setUserName(resultSet.getString(2));
            users.setPassword(resultSet.getString(3));
            users.setSex(resultSet.getString(4));
            users.setEmail(resultSet.getString(5));
            list.add(users);
        }
        this.pstm.close();
        return list;
    }

    //查询用户个人信息
    @Override
    public Users findself(String email) throws SQLException {
        Users users = new Users();
        //sql语句
        String sql = "select * from users where email = ?";

        //数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,email);

        ResultSet resultSet = this.pstm.executeQuery();

        while (resultSet.next()){
            users.setUserId(resultSet.getInt(1));
            users.setUserName(resultSet.getString(2));
            users.setPassword(resultSet.getString(3));
            users.setSex(resultSet.getString(4));
            users.setEmail(resultSet.getString(5));
        }

        this.pstm.close();
        return users;
    }

    @Override
    public boolean emailexist(String email) throws SQLException {
        boolean flag = true;
        //查询该邮箱是否存在
        String sql = "select *from users where email = ?";
        //数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,email);
        ResultSet resultSet = this.pstm.executeQuery();
        if(!resultSet.next()){
            flag = false;
        };

        this.pstm.close();
        return flag;
    }

    //注销
    @Override
    public boolean delete(String userId) throws SQLException {
        boolean flag = false;
        //将要修改的用户的状态改为0
        String sql = "update users SET state = '0' where userId = ?";
        //数据库操作对象
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,userId);
        int i = this.pstm.executeUpdate();
        if(i > 0){
            flag = true;
        }
        this.pstm.close();
        return flag;
    }

    @Override
    public boolean login(String email,String password) throws SQLException {
        boolean flag = false;
        String sql = "select count(*) from users where email = ? and password = ?";
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,email);
        this.pstm.setString(2,password);

        ResultSet resultSet = this.pstm.executeQuery();
        int num = 0;
        while (resultSet.next()){
            num = resultSet.getInt("count(*)");
            System.out.println("进入了"+num);
        }
        if(resultSet.next()){

        }

        if(num > 0 ){
            flag = true;
        }
        this.pstm.close();
        return flag;
    }

    @Override
    public int quanx(String email) throws SQLException {
        String sql = "select juri from users where email = ?";
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,email);
        ResultSet resultSet = this.pstm.executeQuery();
        int juri = -1;
        while (resultSet.next()){
            juri = resultSet.getInt("juri");
        }
        return juri;
    }

    //修改用户信息
    @Override
    public boolean update(Users users,String oldpassword) throws SQLException {
        boolean flag = false;
        String sql = "update users set userName = ? ,password =?,sex =?where email = ? and password = ?";
        this.pstm = this.conn.prepareStatement(sql);
        this.pstm.setString(1,users.getUserName());
        this.pstm.setString(2,users.getPassword());
        this.pstm.setString(3,users.getSex());
        this.pstm.setString(4,users.getEmail());
        this.pstm.setString(5,oldpassword);

        int i = this.pstm.executeUpdate();

        if(i > 0){
            flag = true;
        }
        return flag;
    }
}
