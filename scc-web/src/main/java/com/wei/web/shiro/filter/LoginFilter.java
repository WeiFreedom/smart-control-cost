package com.wei.web.shiro.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wei.utils.constant.AppCode;
import com.wei.utils.constant.AppConstant;
import com.wei.web.domain.ResultVo;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * shiro登录过滤器
 * 默认情况下 如果shiro验证失败 会进入到login.jsp的路径 但是目前不需要这么跳转
 */
public class LoginFilter extends UserFilter {
    /**
     * 这个方法用于处理未登录时页面重定向的逻辑
     * 因此，只要进入了这个方法，就意味着登录失效了
     * 我们只需要在这个方法里，给前端返回一个登录失效的状态码即可
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        // 自定义返回内容
        response.getWriter().write(mapper.writeValueAsString(new ResultVo(AppCode.ERROR,"无权访问", AppConstant.NO)));
    }
}
