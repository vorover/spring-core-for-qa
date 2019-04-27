package com.acme.banking.dbo.my_ooad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("currencyService")
@PropertySource("classpath:app.properties")
public class NostalgieXchangeService implements XchangeService {
    @Value("${rurToUsdRate}")
    private double rurToUsdRate;
    public void setRurToUsdRate(double rate) {
        this.rurToUsdRate = rate;
    }
    public double convert(double sum) {
        return sum / this.rurToUsdRate;
    }

    public double getRate() {
        return this.rurToUsdRate;
    }
}
