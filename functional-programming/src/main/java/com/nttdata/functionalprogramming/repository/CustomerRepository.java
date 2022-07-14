package com.nttdata.functionalprogramming.repository;

import com.nttdata.functionalprogramming.model.CategoryCustomer;
import com.nttdata.functionalprogramming.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    public Customer findByNumberID(String dniCustomer);
    public List<Customer> findByLastName(String lastNameCustomer);
    public List<Customer> findByCategory(CategoryCustomer categoryCustomer);
}
