package com.acme.banking.dbo.spring.domain;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Inheritance
@DiscriminatorColumn(name="ACCOUNT_TYPE")
public abstract class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    private double amount;
    @Email @Size(max = 50) private String email;

    public Account() {
    }

    public Account(double amount, String email) {
        this.amount = amount;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}
