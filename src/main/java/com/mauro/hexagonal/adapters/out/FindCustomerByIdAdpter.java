package com.mauro.hexagonal.adapters.out;

import com.mauro.hexagonal.adapters.out.repository.CustomerRepository;
import com.mauro.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mauro.hexagonal.application.core.domain.Customer;
import com.mauro.hexagonal.application.ports.out.FindCustomerByIdOutinputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class FindCustomerByIdAdpter implements FindCustomerByIdOutinputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        return customerRepository.findById(id).map(entity ->customerEntityMapper.toCustomer(entity) );
    }
}
