package com.mauro.hexagonal.application.core.usecase;

import com.mauro.hexagonal.application.core.domain.Customer;
import com.mauro.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mauro.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mauro.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.mauro.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {


    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {

        var address = this.findAddressByZipCodeOutputPort.find(zipCode);

        customer.setAddress(address);

        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());

    }


}
