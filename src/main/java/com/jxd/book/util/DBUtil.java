package com.jxd.book.util;

/**
 * @ClassName DBUtil
 * @Description TODO
 * @Author liujianpeng
 * @Date 2022/8/10
 * @Version 1.0
 */

import java.sql.*;

public class DBUtil {
    //定义四个静态变量
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3307/javaweb?serverTimezone=UTC";
    private static String user = "root";
    private static String password = "123456";

    public static Connection getConn() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


