package com.BankingApplication.CustomerController;

import com.BankingApplication.CustomerEntity.Customer;
import com.BankingApplication.CustomerService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> saveCustomerInformation(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Customer> getCustomersInformation() {
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerInformation(@PathVariable Long id) {
        Customer existingCustomer = customerService.getCustomer(id);
        return existingCustomer;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {
        Customer deletedCustomer = customerService.deleteCustomer(id);
        return new ResponseEntity<>(deletedCustomer, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Customer> updateCustomerInformation(@RequestBody Customer customer) {
        Customer uppdatedCustomer = customerService.updateCustomerInformation(customer);
        return new ResponseEntity<>(uppdatedCustomer, HttpStatus.CREATED);
    }

}
