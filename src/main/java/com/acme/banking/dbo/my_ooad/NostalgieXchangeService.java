package com.acme.banking.dbo.my_ooad;

public class NostalgieXchangeService implements XchangeService {
    private double rate;
    public NostalgieXchangeService(double rate) {
        this.rate = rate;
    }
    public double convert(double sum) {
        return sum / this.rate;
    }

    public double getRate() {
        return this.rate;
    }
}
