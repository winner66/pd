package com.chk.pd.common.web;

import com.chk.pd.common.interceptor.TokenCheckInterceptor;
import com.chk.pd.pub.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Controller
public class SecurityConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private UserDao userDao;

    private void addTokenInterceptor(InterceptorRegistry registry) {
        TokenCheckInterceptor interceptor = new TokenCheckInterceptor(userDao);
        InterceptorRegistration registration = registry.addInterceptor(interceptor);
        registration.addPathPatterns("/order/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        addTokenInterceptor(registry);
    }

}
