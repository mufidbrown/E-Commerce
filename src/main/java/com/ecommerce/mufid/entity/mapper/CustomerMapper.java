package com.ecommerce.mufid.entity.mapper;

import com.ecommerce.mufid.dto.CustomerDTO;
import com.ecommerce.mufid.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDto(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setCode(customer.getCode());
        dto.setName(customer.getName());
        dto.setAlamatPengiriman(customer.getAlamatPengiriman());
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setCustomerId(dto.getCustomerId());
        customer.setCode(dto.getCode());
        customer.setName(dto.getName());
        customer.setAlamatPengiriman(dto.getAlamatPengiriman());
        return customer;
    }

}
