package com.sys.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author : Cyan_RA9
 * @version : 21.0
 */
public class JDBCUtilsDruid {
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(JDBCUtilsDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放资源
    /**
     * 1.使用了数据库连接池技术后，close并不是真正地关闭与数据库的连接，
     * 而只是取消了对连接池中连接的引用，将所用完的Connection对象放回了连接池。
     * 2.简单地说，由于Connection本身是个接口，因此根据动态绑定机制，实际中调用
     * 的close方法可以来自不同的实现类，底层处理机制也自然不尽相同。
     */

}