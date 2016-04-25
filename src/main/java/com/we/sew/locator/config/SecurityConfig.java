package com.we.sew.locator.config;

import com.we.sew.locator.web.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Vladyslav_Yemelianov
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@ComponentScan("com.we.sew.locator.service.rest")
public class SecurityConfig {

//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().fullyAuthenticated()
//                .and().formLogin().loginPage(WebUtil.Mapping.LOGIN).permitAll()
//                .failureUrl(WebUtil.Mapping.LOGIN).permitAll()
//                .and().logout().permitAll();
//        http.csrf().disable();
//    }
}
