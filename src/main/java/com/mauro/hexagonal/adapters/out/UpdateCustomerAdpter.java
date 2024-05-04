package com.mauro.hexagonal.adapters.out;


import com.mauro.hexagonal.adapters.out.repository.CustomerRepository;
import com.mauro.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mauro.hexagonal.application.core.domain.Customer;
import com.mauro.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdpter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
    }
}
