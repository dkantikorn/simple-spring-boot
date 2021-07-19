package com.example.demo.services;

import com.example.demo.entity.customer.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    /**
     * List for all customer
     *
     * @return
     */
    public List<Customer> retrieveCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    /**
     * Find customer by customer ID
     *
     * @param id
     * @return
     */
    public Optional<Customer> retrieveCustomer(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * Find customer by first name
     *
     * @param firstName
     * @return
     */
    public List<Customer> retrieveCustomer(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    /**
     * Insert for new customer
     *
     * @param customer
     * @return
     */
    public Customer createCustomer(Customer customer) {
        customer.setId(null);
        return customerRepository.save(customer);
    }

    /**
     *
     * Update for customer with customer ID
     * @param id
     * @param customer
     * @return
     */
    public Optional<Customer> updateCustomer(Long id, Customer customer) {
        Optional<Customer> customerInfo = customerRepository.findById(id);
        if (!customerInfo.isPresent()) {
            return customerInfo;
        }
        customer.setId(id);
        return Optional.of(customerRepository.save(customer));
    }

    /**
     * Delete for customer with customer ID
     * @param id
     * @return
     */
    public boolean deleteCustomer(Long id) {
        try {
            Optional<Customer> custInfo = customerRepository.findById(id);
            if (custInfo.isPresent()) {
                customerRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
    }

}
