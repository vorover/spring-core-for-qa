package com.acme.banking.dbo.ooad.domain;

public class SavingAccount implements Withdrawable {
    private long id;
    private double amount;

    public SavingAccount(long id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    @Override //Template method
    public void withdraw(double amount) {
        if (validate(amount)) //Guard clauses
            throw new IllegalStateException("Not enough funds to withdraw");

        this.amount -= amount;
    }

    //step
    protected boolean validate(double amount) {
        return amount > this.amount;
    }
}
