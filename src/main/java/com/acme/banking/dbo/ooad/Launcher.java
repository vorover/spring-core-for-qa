package com.acme.banking.dbo.ooad;

import com.acme.banking.dbo.ooad.service.NostalgieConvertingService;
import com.acme.banking.dbo.ooad.service.TransferService;

public class Launcher {
    public static void main(String[] args) {
        TransferService transferService = new TransferService(
                new NostalgieConvertingService());

        transferService.exchange();
    }
}
