package com.example.service.impl;

import com.example.persistence.entity.Customer;
import com.example.persistence.mapper.CustomerMapper;
import com.example.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAll() {
        return customerMapper.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Customer> findById(Integer id) {
        return customerMapper.findById(id);
    }

    @Transactional
    @Override
    public int insert(Customer customer) {
        return customerMapper.insert(customer);
    }
}
