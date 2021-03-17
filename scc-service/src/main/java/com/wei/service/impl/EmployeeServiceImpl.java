package com.wei.service.impl;

import com.wei.dao.EmployeeMapper;
import com.wei.dto.EmployeeDto;
import com.wei.entity.Employee;
import com.wei.entity.criteria.EmployeeQuery;
import com.wei.mapstruct.EmployeeConvert;
import com.wei.service.IEmployeeService;
import com.wei.utils.AssertUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getEmployeeByCode(String code){
        EmployeeQuery query = new EmployeeQuery();
        query.createCriteria().andDrCodeEqualTo(code);
        List<Employee> employees= employeeMapper.selectByExample(query);
        return employees.stream().findFirst().orElse(null);
    }

    public EmployeeDto getEmployeeDtoByCode(String code){
        Employee employee = getEmployeeByCode(code);
        return EmployeeConvert.INSTANCE.employeeToEmployeeDto(employee);
    }

//    @Override
//    public boolean login(String code, String password) {
//        AssertUtils.notEmpty(code,"用户名不能为空!");
//        AssertUtils.notEmpty(password,"密码不能为空!");
//
//        Employee employee = getEmployeeByCode(code);
//        //用户认证信息
//        Subject subject = SecurityUtils.getSubject();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(employee.getDrCode(), employee.getPassword());
//        try {
//            //进行验证，这里可以捕获异常，然后返回对应信息
//            subject.login(usernamePasswordToken);
////            subject.checkRole("admin");
////            subject.checkPermissions("query", "add");
//        } catch (UnknownAccountException e) {
//            log.error("用户名不存在！", e);
//            return false;
//        } catch (AuthenticationException e) {
//            log.error("账号或密码错误！", e);
//            return false;
//        } catch (AuthorizationException e) {
//            log.error("没有权限！", e);
//            return false;
//        }
//        return true;
//    }
    @Override
    public boolean login(String code, String password){
        AssertUtils.notEmpty(code,"用户名不能为空!");
        AssertUtils.notEmpty(password,"密码不能为空!");
        Employee employee = getEmployeeByCode(code);
        if(employee==null){
            return false;
        }
        if(password.equals(employee.getPassword())){
            return true;
        }
        return false;
    }

    @Override
    public boolean logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return true;
    }
}
