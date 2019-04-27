package com.acme.banking.dbo.my_ooad;

import java.util.Collection;

public class FrameworkApp {
    public static void main(String[] args) {
        NostalgieXchangeService xchangeService = new NostalgieXchangeService();
        xchangeService.setRurToUsdRate(30);
        ReportingService reportingService = new ReportingService(
                xchangeService, new AccountRepository()
        );

        Collection<Account> accounts = reportingService.getAllAccountsInUsd();
        accounts.forEach(
                a -> System.out.println(a.getAmount())
        );
    }
}


