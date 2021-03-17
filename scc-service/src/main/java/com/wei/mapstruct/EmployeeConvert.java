package com.wei.mapstruct;

import com.wei.dto.DeptDto;
import com.wei.dto.EmployeeDto;
import com.wei.entity.Dept;
import com.wei.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeConvert {
    /**
     * 转换类的实例对象
     */
    EmployeeConvert INSTANCE = Mappers.getMapper(EmployeeConvert.class);

    EmployeeDto employeeToEmployeeDto(Employee dept);

    List<EmployeeDto> employeeListToEmployeeDtoList(List<Employee> deptList);
}
