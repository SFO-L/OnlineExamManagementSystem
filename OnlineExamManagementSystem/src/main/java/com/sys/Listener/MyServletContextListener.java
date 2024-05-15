package com.sys.Listener;

import com.sys.db.DBconnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author SfO
 * @Version 1.0
 */
@WebListener()
public class MyServletContextListener implements ServletContextListener {
    @Override
    //监听context域对象的创建
    public void contextInitialized(ServletContextEvent sce) {
        //就是被监听的对象---ServletContext
        ServletContext servletContext = sce.getServletContext();
        //getSource就是被监听的对象的通用的方法
        ServletContext source = (ServletContext) sce.getSource();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Servletcontext已创建"+formatter.format(date));

        //连接池
//        Map map = new HashMap();
//        for(int i = 0; i< 20;i++){
//            try {
//                DBconnection db = new DBconnection();
//                Connection connection = db.getConn();
//                map.put(connection,true);//true空闲，false正在被使用
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } catch (ClassNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        ServletContext application = sce.getServletContext();
//        application.setAttribute("key1",map);
    }
    //监听Servletcontext域对象的销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        System.out.println("Servletcontext已销毁"+formatter.format(date));
        //销毁连接池
//        ServletContext servletContext = sce.getServletContext();
//        Map key1 = (Map)servletContext.getAttribute("key1");
//        servletContext.removeAttribute("key1");
//        System.out.println("lis-des");
    }


}
