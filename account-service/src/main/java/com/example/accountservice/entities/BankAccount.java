package com.example.accountservice.entities;

import com.example.accountservice.model.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id
    private Long id;
    private Long balance;
    private LocalDate createdAt;
    private String currency;
    private Long customerId;
    @Transient
    private Customer customer;
}
