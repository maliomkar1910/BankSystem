package com.BankingApplication.CustomerService;

import com.BankingApplication.CustomerEntity.Customer;
import com.BankingApplication.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplimentaion implements CustomerService{
    @Autowired
    public CustomerRepository customerRepository;
    @Override
    public List<Customer> getCustomers() {
        List<Customer> all_Customer = customerRepository.findAll();
        return all_Customer;
    }

    @Override
    public Customer getCustomer(Long id) {
        Customer Customer_Information = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer not Found with this ID "));
        return Customer_Information;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer saved_Customer = customerRepository.save(customer);
        return saved_Customer;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer saved_Customer = customerRepository.findById(id).orElseThrow(()->new RuntimeException("Customer does not exist"));
        customerRepository.delete(saved_Customer);
        return saved_Customer;
    }

    @Override
    public Customer updateCustomerInformation(Customer customer) {
        Customer existingCustomer = customerRepository.findById(customer.getId()).
                orElseThrow(()-> new RuntimeException("The Customer not found "+customer.getId()));
       existingCustomer.setId(customer.getId());
       existingCustomer.setName(customer.getName());
       existingCustomer.setAddress(customer.getAddress());
       existingCustomer.setEmail(customer.getEmail());
       existingCustomer.setPhone(customer.getPhone());
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return updatedCustomer;
    }
}
