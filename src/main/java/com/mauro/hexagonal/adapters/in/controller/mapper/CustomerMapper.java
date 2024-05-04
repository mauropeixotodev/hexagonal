package com.mauro.hexagonal.adapters.in.controller.mapper;

import com.mauro.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mauro.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mauro.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "name", source = "name")
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
