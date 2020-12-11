package com.gkcx.demo;

import java.sql.*;
import java.util.ServiceLoader;

public class demo1 {
    public static void main(String[] args) {
        //String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名******
        String url = "jdbc:mysql://localhost:3306/gkcx?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
        // MySQL配置时的用户名
        String user = "root";
        // Java连接MySQL配置时的密码******
        String password = "123456";
        try {
            // 加载驱动程序
            //Object a=Class.forName(driver);
            //ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);

            // 连续数据库

            Connection conn = DriverManager.getConnection(url, user, password);
            if(!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            // statement用来执行SQL语句
            Statement statement = conn.createStatement();

            // 要执行的SQL语句id和content是表review中的项。
            String sql = "select DISTINCT id ,content from review ";
            ResultSet rs = statement.executeQuery(sql);


            //输出id值和content值
            while(rs.next()) {
                System.out.println(rs.getString("id") + "\t" + rs.getString("content"));
            }
            rs.close();
            conn.close();
        } catch(SQLException e) {
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
