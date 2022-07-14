package com.nttdata.functionalprogramming.service;

import com.nttdata.functionalprogramming.model.CategoryCustomer;
import com.nttdata.functionalprogramming.model.Customer;
import com.nttdata.functionalprogramming.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomersByCategory(CategoryCustomer categoryCustomer) {
        return customerRepository.findByCategory(categoryCustomer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customerDB = customerRepository.findByNumberID ( customer.getDniCustomer () );
        if (customerDB != null){
            return  customerDB;
        }

        customer.setState("CREATED");
        customerDB = customerRepository.save ( customer );
        return customerDB;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = getCustomer(customer.getIdCustomer());
        if (customerDB == null){
            return  null;
        }
        customerDB.setFirstNameCustomer(customer.getFirstNameCustomer());
        customerDB.setLastNameCustomer(customer.getLastNameCustomer());
        customerDB.setEmailCustomer(customer.getEmailCustomer());
        customerDB.setDniCustomer(customer.getDniCustomer());

        return  customerRepository.save(customerDB);
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        Customer customerDB = getCustomer(customer.getIdCustomer());
        if (customerDB ==null){
            return  null;
        }
        customer.setState("DELETED");
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String idCustomer) {
        return  customerRepository.findById(idCustomer).orElse(null);
    }
}
