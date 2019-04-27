package com.acme.banking.dbo.my_ooad;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository("accountRepository")
public class AccountRepository {
    private Collection<Account> accounts;

    public AccountRepository() {
        Account account1 = new Account(1);
        Account account2 = new Account(2);
        account1.setAmount(100);
        account2.setAmount(200);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        this.accounts = accounts;
    }

    public Collection<Account> getAllAccounts() {
        return accounts;
    }

    public Account getAccount(long id) {
        for (Account acc: accounts) {
            if (acc.getId() == id) return acc;
        }
        return null;
    }
}
