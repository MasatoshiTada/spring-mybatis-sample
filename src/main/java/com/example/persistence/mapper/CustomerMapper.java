package com.example.persistence.mapper;

import com.example.persistence.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerMapper {

    List<Customer> findAll();

    Optional<Customer> findById(Integer id);

    int insert(Customer customer);
}
