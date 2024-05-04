package com.mauro.hexagonal.config;

import com.mauro.hexagonal.adapters.out.FindAddressByZipCodeAdpter;
import com.mauro.hexagonal.adapters.out.InsertCustumerAdpter;
import com.mauro.hexagonal.adapters.out.SendCpfValidationAdpter;
import com.mauro.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdpter findAddressByZipCodeAdpter, InsertCustumerAdpter insertCustumerAdpter, SendCpfValidationAdpter sendCpfValidationAdpter) {

        return new InsertCustomerUseCase(findAddressByZipCodeAdpter, insertCustumerAdpter, sendCpfValidationAdpter);
    }


}
