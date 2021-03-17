package com.wei.web.shiro.config;

import com.wei.web.shiro.jwt.JwtFilter;
import com.wei.web.shiro.realm.ShiroRealm;
import com.wei.web.shiro.filter.LoginFilter;
import com.wei.web.shiro.session.RedisSession;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    //将自己的验证方式加入容器
    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm customRealm = new ShiroRealm();
        return customRealm;
    }

    //权限管理，配置主要是Realm的管理认证
    @Bean
    public SecurityManager securityManager(RedisSession redisSession) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        securityManager.setSessionManager(defaultWebSessionManager(redisSession));
        return securityManager;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //过滤器
        Map<String, Filter> filters = shiroFilterFactoryBean.getFilters();
        /**
         * authc（authentication）拦截器表示需要身份认证通过后才能访问
         * anon（anonymous）拦截器表示匿名访问（即不需要登录即可访问）
         * [urls] 部分的配置，其格式是：“url=拦截器[参数]，拦截器[参数]”；
         * */
        //只需要shiro 不需要jwt的时候可以使用这个LoginFilter
        //filters.put("authc", new LoginFilter());
        //JwtFilter整合
        filters.put("authc", new JwtFilter());

        //权限
        Map<String, String> map = new HashMap<>();
        //放开一部分权限
        //文档的权限
        map.put("/doc.html","anon");
        map.put("/swagger-resources/**", "anon");
        map.put("/webjars/**", "anon");
        map.put("/v2/api-docs", "anon");
        map.put("/swagger-ui.html", "anon");
        //登录/注销的权限
        map.put("/api/employee/login", "anon");
        map.put("/api/employee/logout", "anon");
        //登出
        // map.put("/logout", "logout");
        //对所有用户认证
        map.put("/**", "authc");
        //登录
        //shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        //shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        //shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    @Bean
    public SessionManager defaultWebSessionManager(RedisSession redisSession){
        DefaultWebSessionManager defaultWebSessionManager = new DefaultWebSessionManager();
        defaultWebSessionManager.setSessionIdUrlRewritingEnabled(false);
        defaultWebSessionManager.setSessionDAO(redisSession);
        return defaultWebSessionManager;
    }
}
