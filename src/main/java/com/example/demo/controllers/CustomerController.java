package com.example.demo.controllers;

import com.example.demo.entity.customer.Customer;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * List for all customer
     *
     * @return
     */
    @GetMapping()
    public List<Customer> getCustomers() {
        return customerService.retrieveCustomer();
    }

    /**
     * Find customer by customerID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {

        Optional<Customer> cust = customerService.retrieveCustomer(id);
        if (!cust.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cust);
    }

    /**
     * Find customer by customer first name
     *
     * @param name
     * @return
     */
    @GetMapping(params = "name")
    public List<Customer> getCustomer(@RequestParam(value = "name") String name) {
        return customerService.retrieveCustomer(name);
    }

    /**
     *
     * Create new for customer
     * @param body
     * @return
     */
    @PostMapping()
    public ResponseEntity<?> postCustomer(@Valid @RequestBody Customer body){
        Customer customer = customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    /**
     * Update for customer information
     * @param id
     * @param body
     * @return
     */
    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id,@Valid @RequestBody Customer body){
        Optional<Customer> customer = customerService.updateCustomer(id,body);
        if(!customer.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
        if(!customerService.deleteCustomer(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
