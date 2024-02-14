package com.example.accountservice.web;
import com.example.accountservice.clients.CustomerRestClient;
import com.example.accountservice.entities.BankAccount;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RestController
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    @GetMapping("/bank-accounts")
    public List<BankAccount>  bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bank-accounts/{id}")
    public BankAccount findAccountById(@PathVariable Long id){
        BankAccount bankAccount =  bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Bank account not found"));
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

    @PostMapping("/bank-account/add")
    public BankAccount addBankAccount(@RequestBody BankAccount bankAccount){
        bankAccount.setCreatedAt(LocalDate.now());
        return bankAccountRepository.save(bankAccount);
    }

}
