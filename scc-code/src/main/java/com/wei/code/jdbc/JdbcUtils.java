package com.wei.code.jdbc;

import com.wei.code.domain.Disease;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtils {
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://192.168.117.129:3306/smart_hospital?useSSL=false";
    private static final String driver = "com.mysql.jdbc.Driver";


    /**
     * 执行sql
     * @param sql
     * @return
     */
    public static boolean execute(String sql) {
        Connection connection = null;
        Statement statement = null;
        boolean flag = false;
        try {
            Class<?> clazz = Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            flag = statement.executeUpdate(sql) > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * 查询诊断表
     * @param sql
     */
    public static List<Disease> query(String sql){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Disease> diseaseList= new ArrayList<>();
        try {
            Class<?> clazz = Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Disease disease = new Disease();
                disease.setTc_diag_code(resultSet.getString("tc_diag_code"));
                disease.setTc_diag_name( resultSet.getString("tc_diag_name"));
                disease.setTc_diag_type(resultSet.getString("tc_diag_type"));
                disease.setTc_diag_parent_code(resultSet.getString("tc_diag_parent_code"));
                disease.setTc_diag_pinyin( resultSet.getString("tc_diag_pinyin"));
                disease.setTc_sex(resultSet.getString("tc_sex"));

                diseaseList.add(disease);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return diseaseList;
    }
}
