package com.mauro.hexagonal.adapters.out;


import ch.qos.logback.core.CoreConstants;
import com.mauro.hexagonal.adapters.out.repository.CustomerRepository;

import com.mauro.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mauro.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;

import com.mauro.hexagonal.application.core.domain.Customer;

import com.mauro.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustumerAdpter implements InsertCustomerOutputPort {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {

       CustomerEntity c =  customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(c);
    }
}
