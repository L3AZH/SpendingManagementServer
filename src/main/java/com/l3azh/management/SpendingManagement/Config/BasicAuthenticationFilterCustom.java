package com.l3azh.management.SpendingManagement.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class BasicAuthenticationFilterCustom extends OncePerRequestFilter {

    private static Logger basicAuthFilterLogger = LoggerFactory.getLogger(BasicAuthenticationFilterCustom.class.getName());

    @Autowired
    ApplicationContext applicationContext;

    @Value("${basic.auth.name}")
    private String username;

    @Value("${basic.auth.password}")
    private String password;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            Map<String, String> basicAccount = getUsernameAndPasswordFromRequest(request);
            PasswordEncoder passwordEncoder = applicationContext.getBean("passwordEncoder", BCryptPasswordEncoder.class);
            if(basicAccount != null && !basicAccount.isEmpty()){
                if(username.equals(basicAccount.get("username")) && password.equals(basicAccount.get("password"))){
                    UserDetails userDetails = User
                            .withUsername(basicAccount.get("username"))
                            .password(passwordEncoder.encode(basicAccount.get("password")))
                            .roles(UserDetailImpl.AccCusRole.USER.getValue())
                            .build();
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
                }
            } else {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
            }
        } catch (Exception e){
            basicAuthFilterLogger.error(String.format("Cannot set user authentication : \n %s", e.getMessage()));
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error !!");
        }
    }

    private Map<String, String> getUsernameAndPasswordFromRequest(HttpServletRequest request){
        String headerAuth = request.getHeader("Authorization");
        if (!(headerAuth == null ||
                headerAuth.isBlank() ||
                headerAuth.isEmpty()) && headerAuth.startsWith("Basic ")) {
            String base64String = headerAuth.substring(6, headerAuth.length());
            String base64DecodeString = new String(Base64.getDecoder().decode(base64String), StandardCharsets.UTF_8);
            Map<String, String> info = new HashMap<>();
            String[] data = base64DecodeString.split(":");
            info.put("username", data[0]);
            info.put("password", data[1]);
            return info;
        }
        return null;
    }
}
