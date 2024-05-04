package com.mauro.hexagonal.application.core.usecase;

import com.mauro.hexagonal.application.core.domain.Customer;
import com.mauro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mauro.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.mauro.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mauro.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {


    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCode){
        findCustomerByIdInputPort.find(customer.getId());
        customer.setAddress(findAddressByZipCodeOutputPort.find(zipCode));
        updateCustomerOutputPort.update(customer);
    }


}
