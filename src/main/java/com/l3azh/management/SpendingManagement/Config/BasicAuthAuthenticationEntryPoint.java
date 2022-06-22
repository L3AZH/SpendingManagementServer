package com.l3azh.management.SpendingManagement.Config;

import com.l3azh.management.SpendingManagement.Utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class BasicAuthAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    private static Logger basicAuthEntryPointLogger = LoggerFactory.getLogger(BasicAuthAuthenticationEntryPoint.class.getName());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        basicAuthEntryPointLogger.error(String.format("Unauthorized Error {} \n %s", authException.getMessage()));
        AppUtils.sendError(response, HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("L3azh.SpendingManagement");
        super.afterPropertiesSet();
    }
}
