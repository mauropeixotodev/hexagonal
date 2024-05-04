package com.mauro.hexagonal.application.ports.in;

import com.mauro.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
