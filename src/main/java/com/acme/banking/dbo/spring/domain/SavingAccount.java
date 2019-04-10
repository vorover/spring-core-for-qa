package com.acme.banking.dbo.spring.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;

@Entity
@DiscriminatorValue("S")
public class SavingAccount extends Account {
    public SavingAccount() {
    }

    public SavingAccount(double amount, String email) {
        super(amount, email);
    }
}
