package com.mauro.hexagonal.adapters.out.client.mapper;

import com.mauro.hexagonal.adapters.out.client.response.AddressResponse;
import com.mauro.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {


    Address toAddress(AddressResponse addressResponse);
}
