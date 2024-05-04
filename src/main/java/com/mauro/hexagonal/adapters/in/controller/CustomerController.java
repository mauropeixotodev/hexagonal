package com.mauro.hexagonal.adapters.in.controller;

import com.mauro.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.mauro.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.mauro.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.mauro.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.mauro.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mauro.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mauro.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;

    @Autowired
    private CustomerMapper customerMapper;


    @PostMapping()
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
       var b = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(b, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(customerMapper.toCustomerResponse(findCustomerByIdInputPort.find(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id,@Valid @RequestBody CustomerRequest customerRequest ){
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer,customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}") ResponseEntity<Void> delete(@PathVariable String id){
        deleteCustomerByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();

    }

}




