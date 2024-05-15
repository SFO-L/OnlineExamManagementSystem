package com.sys.db;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author SfO
 * @Version 1.0
 */
public class MyDruid {
    public static void main(String[] args) throws Exception {
        System.out.println(MyDruid.class.getResource("../../druid.properties"));




    }

}
