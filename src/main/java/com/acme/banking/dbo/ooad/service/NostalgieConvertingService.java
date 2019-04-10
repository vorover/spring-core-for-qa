package com.acme.banking.dbo.ooad.service;

public class NostalgieConvertingService implements ConvertingService {
    @Override
    public double convert(double from) {
        return 30*from;
    }
}
