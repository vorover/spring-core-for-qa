package com.acme.banking.dbo.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/** Stateful service */
@Component("currencyService")
@Scope("singleton")
@Lazy
@PropertySource("classpath:app.properties")
public class CurrencyService {
    @Value("${rurToUsdRate}")
    private double rurToUsdRate;

    public void setRurToUsdRate(double rurToUsdRate) {
        this.rurToUsdRate = rurToUsdRate;
    }

    public double getUsdRateForRur() {
        return rurToUsdRate;
    }

    public double getRurRateForUsd() {
        return 1 / getUsdRateForRur();
    }
}
