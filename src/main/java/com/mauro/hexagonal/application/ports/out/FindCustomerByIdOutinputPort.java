package com.mauro.hexagonal.application.ports.out;

import com.mauro.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutinputPort {

    Optional<Customer> find(String id);

}
