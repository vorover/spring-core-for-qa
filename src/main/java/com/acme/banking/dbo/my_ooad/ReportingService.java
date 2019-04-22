package com.acme.banking.dbo.my_ooad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReportingService {
    private AccountRepository repository;
    private XchangeService xchangeService;
    public ReportingService(XchangeService xchangeService, AccountRepository repository) {
        this.xchangeService = xchangeService;
        this.repository = repository;
    }

    //private Collection<Account> accounts;

    public Collection<Account> getAllAccountsInUsd() {
        /*return repository.getAllAccounts().
                forEach(account -> account.setAmount(
                        account.getAmount() / xchangeService.getRate()
                ));*/
        Collection<Account> accounts = repository.getAllAccounts();
        for(Account acc : accounts) {
            acc.setAmount(acc.getAmount()/xchangeService.getRate());
        }
        return accounts;
    }
}

class AccountRepository {
    public Collection<Account> getAllAccounts() {
        Account account1 = new Account();
        Account account2 = new Account();
        account1.setAmount(100);
        account2.setAmount(200);
        List<Account> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        return accounts;
    }
}
