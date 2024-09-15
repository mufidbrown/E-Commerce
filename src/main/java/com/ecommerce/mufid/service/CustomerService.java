package com.ecommerce.mufid.service;

import com.ecommerce.mufid.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

        CustomerDTO createCustomer(CustomerDTO customerDTO);
        CustomerDTO updateCustomer(Long customerId, CustomerDTO customerDTO);
        void deleteCustomer(Long customerId);
        CustomerDTO getCustomerById(Long customerId);
        List<CustomerDTO> getAllCustomers();

}
