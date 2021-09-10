package com.darwin.wasterecycling.config.security.applet;

import com.darwin.wasterecycling.config.security.SimpleAuthFailureHandler;
import com.darwin.wasterecycling.config.security.SimpleAuthSuccessHandler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import javax.servlet.Filter;

public class AppletLoginConfigurer<T extends AppletLoginConfigurer<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {

    private RestTemplate restTemplate;

    public AppletLoginConfigurer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public void configure(B http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
        http.addFilterBefore(getFilter(authenticationManager), UsernamePasswordAuthenticationFilter.class);
    }

    private Filter getFilter(AuthenticationManager authenticationManager){
        AppletAuthenticationProcessingFilter filter = new AppletAuthenticationProcessingFilter(authenticationManager);
        filter.setAllowSessionCreation(true);
        filter.setAuthenticationSuccessHandler(new SimpleAuthSuccessHandler());
        filter.setAuthenticationFailureHandler(new SimpleAuthFailureHandler());
        return filter;
    }
}
