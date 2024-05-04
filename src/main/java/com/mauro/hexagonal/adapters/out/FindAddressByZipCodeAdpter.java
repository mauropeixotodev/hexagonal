package com.mauro.hexagonal.adapters.out;

import com.mauro.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.mauro.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.mauro.hexagonal.application.core.domain.Address;
import com.mauro.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdpter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        return addressResponseMapper.toAddress(findAddressByZipCodeClient.find(zipCode));
    }
}
