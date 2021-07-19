package com.example.demo.repository;

import com.example.demo.entity.customer.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    List<Customer> findByFirstName(String firstName);
}
