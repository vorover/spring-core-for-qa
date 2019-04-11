package com.acme.banking.dbo.ooad.service;

import com.acme.banking.dbo.ooad.domain.Withdrawable;

public class TransferService {
    private ConvertingService convertingService; //Creator [GRASP]

    public TransferService(ConvertingService convertingService) {
        this.convertingService = convertingService;
    }

    @RollesAllowed
    @Retry
    @Log
    @Transactional
    @Valid
    @Async
    @Cache("key")
    @Timer
    public void withdraw(Withdrawable from, double amount) {
        from.withdraw(amount);
    }

    public void exchange() {
        //......
        convertingService.convert(1L);
    }
}
