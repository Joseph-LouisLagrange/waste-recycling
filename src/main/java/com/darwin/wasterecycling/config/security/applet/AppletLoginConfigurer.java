package com.darwin.wasterecycling.config.security.applet;

import com.darwin.wasterecycling.config.security.SimpleAuthFailureHandler;
import com.darwin.wasterecycling.config.security.SimpleAuthSuccessHandler;
import com.darwin.wasterecycling.dto.LoginDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;

public class AppletLoginConfigurer<H extends HttpSecurityBuilder<H>> extends
        AbstractAuthenticationFilterConfigurer<H, AppletLoginConfigurer<H>, AppletAuthenticationProcessingFilter> {

    private RestTemplate restTemplate;

    public AppletLoginConfigurer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void configure(H http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.addFilter(getFilter(authenticationManager))
                .authenticationProvider(new AppletAuthenticationProvider(restTemplate));

    }

    @Override
    protected RequestMatcher createLoginProcessingUrlMatcher(String loginProcessingUrl) {
        return new AntPathRequestMatcher(loginProcessingUrl);
    }

    private Filter getFilter(AuthenticationManager authenticationManager){
        AppletAuthenticationProcessingFilter filter = new AppletAuthenticationProcessingFilter(authenticationManager);
        filter.setAllowSessionCreation(true);
        filter.setAuthenticationSuccessHandler(new SimpleAuthSuccessHandler());
        filter.setAuthenticationFailureHandler(new SimpleAuthFailureHandler());
        return filter;
    }
}
