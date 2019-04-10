package com.acme.banking.dbo.spring.service;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class ReportingService {
    @Autowired(required = false)
    private CurrencyService currencyService;

    @Resource /** Like @Autowired but with JNDI support */
    private AccountRepository accountRepository;

    @PostConstruct
    public void onCreate() {
        System.out.println("ReportingService created");
    }

    @PreDestroy
    public void onShutDown() {
        System.out.println("ReportingService shut down");
    }

    public double getUsdAmountFor(long accountId) {
        double rurAmount = accountRepository.findById(accountId).get().getAmount();
        return currencyService.getUsdRateForRur() * rurAmount;
    }
}
