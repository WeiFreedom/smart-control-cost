package com.wei.dao;

import com.wei.entity.Employee;
import com.wei.entity.criteria.EmployeeQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    long countByExample(EmployeeQuery example);

    int deleteByExample(EmployeeQuery example);

    int deleteByPrimaryKey(Integer drId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeQuery example);

    Employee selectByPrimaryKey(Integer drId);

    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeQuery example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeQuery example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}