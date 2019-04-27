package com.acme.banking.dbo.my_ooad;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("xchangeService")
public interface XchangeService {
    double convert(double sum);
    double getRate();
}
