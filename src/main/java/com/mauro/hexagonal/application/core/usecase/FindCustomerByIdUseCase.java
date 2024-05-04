package com.mauro.hexagonal.application.core.usecase;

import com.mauro.hexagonal.application.core.domain.Customer;
import com.mauro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mauro.hexagonal.application.ports.out.FindCustomerByIdOutinputPort;


public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

private final FindCustomerByIdOutinputPort findCustomerByIdOutinputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutinputPort findCustomerByIdOutinputPort) {
        this.findCustomerByIdOutinputPort = findCustomerByIdOutinputPort;
    }


    @Override
    public Customer find(String id) {
        return findCustomerByIdOutinputPort.find(id).orElseThrow(()-> new RuntimeException("Customer Not found"));
    }
}
