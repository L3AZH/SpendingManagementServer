package com.l3azh.management.SpendingManagement.Config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper providerModelMapper(){
        return new ModelMapper();
    }
}
