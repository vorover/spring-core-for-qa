package com.acme.banking.dbo.my_ooad;

import java.util.Collection;

public class FrameworkApp {
    public static void main(String[] args) {
        ReportingService reportingService = new ReportingService(
                new NostalgieXchangeService(30), new AccountRepository()
        );

        Collection<Account> accounts = reportingService.getAllAccountsInUsd();
        accounts.forEach(
                a -> System.out.println(a.getAmount())
        );
    }
}

class Account {
    private long id;
    //public AccountType type;
    private double amount;
    private double creditLimit; //state

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
