package com.mauro.hexagonal.config;

import com.mauro.hexagonal.adapters.out.DeleteCustomerByIdAdpter;
import com.mauro.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.mauro.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, DeleteCustomerByIdAdpter deleteCustomerByIdAdpter) {

        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdpter);
    }

}
