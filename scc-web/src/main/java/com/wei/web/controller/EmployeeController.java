package com.wei.web.controller;

import com.wei.dto.EmployeeDto;
import com.wei.entity.Dept;
import com.wei.entity.Employee;
import com.wei.service.IEmployeeService;
import com.wei.service.IDeptService;
import com.wei.utils.constant.AppCode;
import com.wei.utils.constant.AppConstant;
import com.wei.utils.jwt.JwtUtils;
import com.wei.web.domain.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "人员模块")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

//    @PostMapping("/login")
//    @ApiOperation(value = "登录")
//    public ResultVo login(String code, String password) {
//        boolean result = employeeService.login(code, password);
//        if (result) {
//            return new ResultVo(AppCode.SUCESS, "登录成功", AppConstant.OK);
//        } else {
//            return new ResultVo(AppCode.ERROR, "登录失败", AppConstant.NO);
//        }
//    }
    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public ResultVo login(String code, String password) {
        boolean result = employeeService.login(code, password);
        if (result) {
            EmployeeDto dto = employeeService.getEmployeeDtoByCode(code);
            dto.setToken(JwtUtils.createToken(code,password));
            return new ResultVo(AppCode.SUCESS, "登录成功", dto);
        } else {
            return new ResultVo(AppCode.ERROR, "登录失败", AppConstant.NO);
        }
    }

    @PostMapping("/logout")
    @ApiOperation(value = "注销")
    public ResultVo logout() {
        boolean result = employeeService.logout();
        if (result) {
            return new ResultVo(AppCode.SUCESS, "注销成功", AppConstant.OK);
        } else {
            return new ResultVo(AppCode.ERROR, "注销失败", AppConstant.NO);
        }
    }
}
