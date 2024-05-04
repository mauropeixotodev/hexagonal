package com.mauro.hexagonal.config;

import com.mauro.hexagonal.adapters.out.FindCustomerByIdAdpter;
import com.mauro.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdpter findCustomerByIdAdpter){
        return new FindCustomerByIdUseCase(findCustomerByIdAdpter);
    }
}
