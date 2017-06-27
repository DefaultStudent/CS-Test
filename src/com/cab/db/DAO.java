package com.cab.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    protected static String dbClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    protected static String dbUrl = "jdbc:sqlserver://localhost:1433;" + "DatabaseName=CABWeb;";
    protected static String dbUser = "sa";
    protected static String dbPwd = "sql2008";
    private static Connection conn = null;
    /*
     * 
     */
    private DAO() {// ������ݿ�����
        try {
            if (conn == null) {
                Class.forName(dbClassName).newInstance();
                conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            } else
                return;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ResultSet executeQuery(String sql) {// ִ�в�ѯ����
        try {
            if (conn == null)
                new DAO();
            return conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    static int executeUpdate(String sql) {// ִ����������

        try {
            if (conn == null)
                new DAO();
            return conn.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void close() {// �ر�����
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    } 
    
    public static void main(String[] args){
    	System.out.println("hhh");
    }
}