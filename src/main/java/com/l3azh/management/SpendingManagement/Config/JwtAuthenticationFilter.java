package com.l3azh.management.SpendingManagement.Config;

import com.l3azh.management.SpendingManagement.Services.UserDetailImplService;
import com.l3azh.management.SpendingManagement.Utils.AppUtils;
import com.l3azh.management.SpendingManagement.Utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static Logger jwtAuthFilterLogger = LoggerFactory.getLogger(JwtAuthenticationFilter.class.getName());

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserDetailImplService userDetailImplService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromHeaderRequest(request);
            if (jwt != null && jwtUtil.validateJwtToken(jwt)) {
                String email = jwtUtil.getEmailFromJwt(jwt);
                UserDetails userDetails = userDetailImplService.loadUserByUsername(email);
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else if (jwt != null && !jwtUtil.validateJwtToken(jwt)) {
                AppUtils.sendError(response, HttpServletResponse.SC_UNAUTHORIZED, "Error: Unauthorized");
                return;
            }
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            jwtAuthFilterLogger.error(String.format("Cannot set user authentication : \n %s", e.getMessage()));
            AppUtils.sendError(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    String.format("Cannot set user authentication : \n %s", e.getMessage()));
        }
    }

    private String getJwtFromHeaderRequest(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (!(headerAuth == null ||
                headerAuth.isBlank() ||
                headerAuth.isEmpty()) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
}
