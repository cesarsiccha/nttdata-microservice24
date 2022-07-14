package com.nttdata.functionalprogramming.service;

import com.nttdata.functionalprogramming.model.CategoryCustomer;
import com.nttdata.functionalprogramming.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findCustomerAll();
    public List<Customer> findCustomersByCategory(CategoryCustomer categoryCustomer);

    public Customer createCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public Customer deleteCustomer(Customer customer);
    public  Customer getCustomer(String id);
}
