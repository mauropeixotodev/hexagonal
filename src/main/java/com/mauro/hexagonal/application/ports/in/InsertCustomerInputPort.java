package com.mauro.hexagonal.application.ports.in;

import com.mauro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
