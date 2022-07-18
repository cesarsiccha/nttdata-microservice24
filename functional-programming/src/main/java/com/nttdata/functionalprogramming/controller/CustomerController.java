package com.nttdata.functionalprogramming.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.functionalprogramming.model.CategoryCustomer;
import com.nttdata.functionalprogramming.model.Customer;
import com.nttdata.functionalprogramming.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // -------------------Retrieve All Customers--------------------------------------------

    @GetMapping
    public ResponseEntity<List<Customer>> listAllCustomers(@RequestParam(name = "IdCategoryCustomer" , required = false) Long IdCategoryCustomer ) {
        List<Customer> customers =  new ArrayList<>();
        if (null ==  IdCategoryCustomer) {
            customers = customerService.findCustomerAll();
            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        }else{
            CategoryCustomer categoryCustomer= new CategoryCustomer();
            categoryCustomer.setIdCategoryCustomer(IdCategoryCustomer);
            customers = customerService.findCustomersByCategory(categoryCustomer);
            if ( null == customers ) {
                log.error("Customers with Category id {} not found.", IdCategoryCustomer);
                return  ResponseEntity.notFound().build();
            }
        }

        return  ResponseEntity.ok(customers);
    }

    // -------------------Retrieve Single Customer------------------------------------------

    @GetMapping(value = "/{idCustomer}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("idCustomer") Long idCustomer) {
        log.info("Fetching Customer with id {}", idCustomer);
        Customer customer = customerService.getCustomer(idCustomer);
        if (  null == customer) {
            log.error("Customer with id {} not found.", idCustomer);
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(customer);
    }

    // -------------------Create a Customer-------------------------------------------

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        log.info("Creating Customer : {}", customer);


        Customer customerDB = customerService.createCustomer (customer);

        return  ResponseEntity.status( HttpStatus.CREATED).body(customerDB);
    }

    // ------------------- Update a Customer ------------------------------------------------

    @PutMapping(value = "/{idCustomer}")
    public ResponseEntity<?> updateCustomer(@PathVariable("idCustomer") Long idCustomer, @RequestBody Customer customer) {
        log.info("Updating Customer with id {}", idCustomer);

        Customer currentCustomer = customerService.getCustomer(idCustomer);

        if ( null == currentCustomer ) {
            log.error("Unable to update. Customer with id {} not found.", idCustomer);
            return  ResponseEntity.notFound().build();
        }
        customer.setIdCustomer(idCustomer);
        currentCustomer=customerService.updateCustomer(customer);
        return  ResponseEntity.ok(currentCustomer);
    }

    // ------------------- Delete a Customer-----------------------------------------

    @DeleteMapping(value = "/{idCustomer}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("idCustomer") Long idCustomer) {
        log.info("Fetching & Deleting Customer with id {}", idCustomer);
//
        Customer customer = customerService.getCustomer(idCustomer);
        if ( null == customer ) {
            log.error("Unable to delete. Customer with id {} not found.", idCustomer);
            return  ResponseEntity.notFound().build();
        }
        customer = customerService.deleteCustomer(customer);
        return  ResponseEntity.ok(customer);
    }

//    private String formatMessage( BindingResult result){
//        List<Map<String,String>> errors = result.getFieldErrors().stream()
//                .map(err ->{
//                    Map<String,String>  error =  new HashMap<>();
//                    error.put(err.getField(), err.getDefaultMessage());
//                    return error;
//
//                }).collect(Collectors.toList());
//        ErrorMessage errorMessage = ErrorMessage.builder()
//                .code("01")
//                .messages(errors).build();
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString="";
//        try {
//            jsonString = mapper.writeValueAsString(errorMessage);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        return jsonString;
//    }
}
