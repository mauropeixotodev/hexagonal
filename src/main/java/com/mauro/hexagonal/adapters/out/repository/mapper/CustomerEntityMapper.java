package com.mauro.hexagonal.adapters.out.repository.mapper;

import com.mauro.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mauro.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "isValidCpf", source = "isValidCpf")
    @Mapping(target = "id", source = "id")
    CustomerEntity toCustomerEntity(Customer customer);
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "isValidCpf", source = "isValidCpf")
    @Mapping(target = "id", source = "id")
    Customer toCustomer(CustomerEntity customerEntity);
}
