package com.example.customerservice.web;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
      return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer CustomerById(@PathVariable Long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerOptional.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @PostMapping("customer/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer registerCustomer(@RequestBody Customer newCustomer) {
        // You may want to perform additional validation or business logic before saving the customer
        return customerRepository.save(newCustomer);
    }
}
