package com.mauro.hexagonal.application.ports.out;

import com.mauro.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutputPort {

    void insert(Customer customer);
}
