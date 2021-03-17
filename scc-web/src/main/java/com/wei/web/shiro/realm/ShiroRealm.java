package com.wei.web.shiro.realm;

import com.wei.entity.Employee;
import com.wei.service.IEmployeeService;
import com.wei.utils.constant.AppPermission;
import com.wei.utils.jwt.JwtStatus;
import com.wei.utils.jwt.JwtUtils;
import com.wei.web.shiro.jwt.JwtToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private IEmployeeService IEmployeeService;

    //授权
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo();
//        //暂时先添加ADMIN权限　后期可以根据employee查询出来权限
//        Subject subject = SecurityUtils.getSubject();
//        Employee employee = (Employee) subject.getPrincipal();
//        //可以增加角色 增加权限
//        simple.addRole(AppConstant.ADMIN);
//        return simple;
//    }


//    //认证
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        String code = authenticationToken.getPrincipal().toString();
//        if (StringUtils.isEmpty(code)) {
//            return null;
//        }
//        Employee employee = employeeService.getEmployeeByCode(code);
//        if (employee == null) {
//            return null;
//        }
//        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(employee, employee.getPassword(), "");
//        return simpleAuthenticationInfo;
//    }

    /**
     * 设置realm支持的authenticationToken类型
     */
    @Override
    public boolean supports(AuthenticationToken token){
        return null != token && token instanceof JwtToken;
    }

    //JWT授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection)
            throws AuthenticationException{
        String token = principalCollection.toString();
        //根据token获取权限授权
        String code = JwtUtils.getUserName(token);
        //可以根据获取的人员信息赋值权限
        Employee employee = IEmployeeService.getEmployeeByCode(code);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole(AppPermission.ADMIN);

        //authorizationInfo.setRoles(employee.getRoles());
        //authorizationInfo.setStringPermissions(employee.getPermissions());
        return authorizationInfo;
    }
    /**
     * 登陆认证
     *
     * @param authenticationToken jwtFilter传入的token
     * @return 登陆信息
     * @throws AuthenticationException 未登陆抛出异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        //getCredentials getPrincipal getToken 都是返回jwt生成的token串
        String token = (String) authenticationToken.getCredentials();
        String code = JwtUtils.getUserName(token);
        if (code == null) {
            return null;
        }
        Employee employee = IEmployeeService.getEmployeeByCode(code);
        if(employee==null){
            return null;
        }
        JwtStatus verify = JwtUtils.verify(code, employee.getPassword(), token);
        if (verify== JwtStatus.ERROR) {
            return null;
        } else if(verify==JwtStatus.EXPIRED){
            return null;//暂时先return null
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
