package com.l3azh.management.SpendingManagement.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static Logger jwtAuthEntryPoint = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class.getName());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        jwtAuthEntryPoint.error(String.format("Unauthorized Error {} \n %s",authException.getMessage()));
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error Unauthorized");
    }
}
