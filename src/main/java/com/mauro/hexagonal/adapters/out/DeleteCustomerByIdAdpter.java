package com.mauro.hexagonal.adapters.out;

import com.mauro.hexagonal.adapters.out.repository.CustomerRepository;
import com.mauro.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdpter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);

    }
}
