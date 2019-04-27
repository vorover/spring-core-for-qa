package com.acme.banking.dbo.my_ooad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("reportingService")
public class ReportingService {
    @Autowired
    private AccountRepository repository;
    @Autowired(required = false)
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

    public Double getUsdAmountFor(long id) {
        Account acc = repository.getAccount(id)  ;
        return acc.getAmount()/xchangeService.getRate();
    }
}


