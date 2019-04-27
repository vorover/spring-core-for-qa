package com.acme.banking.dbo.my_ooad;

public class Account {
    private long id;
    //public AccountType type;
    private double amount;
    //private double creditLimit; //state

    public Account(int id) {
        this.id = id;
    }
    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getId() {return this.id; }
}
