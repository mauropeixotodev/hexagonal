package com.mauro.hexagonal.application.ports.out;

import com.mauro.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
