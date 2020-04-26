package com.example.configuration;

import com.example.controller.PetStoreController;
import com.example.exception.GlobalException;
import com.example.repository.PetStoreRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Tags the class as a source of bean

public class PetStoreConfiguration {
    //A JavaBean follows certain conventions. Getter/setter naming, having a public default constructor.
    //Bean name = name of class
    @Bean
    public PetStoreRepository petStoreRepository() {
        return new PetStoreRepository();
    }

    @Bean
    public PetStoreController petStoreController() {
        return new PetStoreController();
    }

    @Bean
    public GlobalException globalException() {
        return new GlobalException();
    }

}