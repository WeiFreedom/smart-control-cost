package com.wei.code.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateUtils {
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://192.168.117.129:3306/smart_hospital?useSSL=false";
    private static final String driver = " com.mysql.jdbc.Driver";
    private static Object lock = new Object();
    private static JdbcTemplate jdbcTemplate;
    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);

        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    /**
     * 更新,插入,删除
     *
     * @param sql sql语句使用 ? 代替变量
     * @param params 可以传入map 或者
     * @return
     */
    public static int update(String sql, Object... params) {
        return jdbcTemplate.update(sql, params);
    }

    /**
     * 更新,插入,删除
     * @param sql sql语句使用 :属性名 代替变量
     * @param entity 可以传入对象
     * @return
     */
    public static int updateByObject(String sql, Object entity){
        SqlParameterSource param = ObjectToParam(entity);
        return namedParameterJdbcTemplate.update(sql,param);
    }

    /**
     * 获取核心诊断疾病相关操作
     * @param drgCode
     * @return
     */
    public static List<String> getAdrgCodeList(String drgCode){
        String sql = "select tc_adrg_code from tb_mdc_adrg where tc_mdc_code = ?";
        //查询一个对象
        //jdbcTemplate.queryForObject(sql,new StringRowMapper(), drgCode);
        //查询多个对象
       List<String> result= jdbcTemplate.query(sql,new StringRowMapper(), drgCode);
       return result;
    }

    /**
     * 将对象转化成SqlParameterSource
     * @param obj
     * @return
     */
    public static SqlParameterSource ObjectToParam(Object obj){
        return new BeanPropertySqlParameterSource(obj);
    }



}
