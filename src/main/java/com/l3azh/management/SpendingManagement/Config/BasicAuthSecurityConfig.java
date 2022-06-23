package com.l3azh.management.SpendingManagement.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
@RequiredArgsConstructor
public class BasicAuthSecurityConfig {

    private final BasicAuthenticationFilterCustom basicAuthenticationFilterCustom;

    private final BasicAuthAuthenticationEntryPoint basicAuthenticationEntryPoint;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain basicAuthConfig(HttpSecurity config) throws Exception {
        config.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(basicAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .antMatcher("/api/auth/**").authorizeRequests()
                .anyRequest().authenticated().and().httpBasic();
        config.addFilterBefore(basicAuthenticationFilterCustom, BasicAuthenticationFilter.class);
        return config.build();
    }
}
