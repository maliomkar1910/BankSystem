package com.BankingApplication.CustomerService;

import com.BankingApplication.CustomerEntity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public Customer getCustomer(Long id);
    public  Customer saveCustomer(Customer customer);
    public Customer deleteCustomer(Long id);

    public  Customer updateCustomerInformation(Customer customer);


}
