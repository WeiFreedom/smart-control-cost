package com.wei.service;

import com.wei.dto.EmployeeDto;
import com.wei.entity.Employee;

public interface IEmployeeService {
    boolean login(String userNo,String password);

    boolean logout();

    Employee getEmployeeByCode(String code);

    EmployeeDto getEmployeeDtoByCode(String code);
}
