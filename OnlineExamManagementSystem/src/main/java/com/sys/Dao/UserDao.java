package com.sys.Dao;

import com.sys.entity.Users;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author SfO
 * @Version 1.0
 */
public interface UserDao {

    /**
     *添加用户数据（用户注册）
     * @param Users
     * */
    public boolean add(Users users) throws Exception;

    /**
     * 查找所有用户信息（管理员）
     * 邮箱唯一
     */
    public List<Users> findall() throws Exception;

    /**
     * 查找个人的信息（用户）
     */
    public Users findself(String email) throws Exception;

    /**
     * 邮箱是否已经存在
     */
    public boolean emailexist(String email) throws SQLException;

    /**
     * 判断是否注销
     */
//    public boolean isexist();

    /**
     * 注销用户
     */
    public boolean delete(String userId) throws Exception;

    /**
     * 用户登录
     */
    public boolean login(String email,String password) throws Exception;

    /**
     * 判断权限
     */
    public int quanx(String email) throws SQLException;

    /**
     * 修改用户信息
     */
    public boolean update(Users users,String oldpassword) throws SQLException;
}
