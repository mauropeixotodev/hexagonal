package com.mauro.hexagonal.config;

import com.mauro.hexagonal.adapters.out.FindAddressByZipCodeAdpter;
import com.mauro.hexagonal.adapters.out.UpdateCustomerAdpter;
import com.mauro.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mauro.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase, FindAddressByZipCodeAdpter findAddressByZipCodeAdpter, UpdateCustomerAdpter updateCustomerAdpter){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,findAddressByZipCodeAdpter,updateCustomerAdpter );
    }
}
