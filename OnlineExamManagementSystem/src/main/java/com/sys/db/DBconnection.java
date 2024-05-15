package com.sys.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author SfO
 * @Version 1.0
 */
public class DBconnection {
    private static final String Driver = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/lab1?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "lyh159357";

    private Connection conn;
    public DBconnection() throws ClassNotFoundException, SQLException {

            Class.forName(Driver);
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);

    }

    public Connection getConn() {
        return this.conn;
    }

    public void close() throws Exception { // 关闭数据库
        if (this.conn != null) {
            try {
                this.conn.close(); // 数据库关闭
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
