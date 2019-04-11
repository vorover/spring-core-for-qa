package com.acme.banking.dbo.ooad;

import com.acme.banking.dbo.ooad.service.NostalgieConvertingService;
import com.acme.banking.dbo.ooad.service.TransferService;

public class Launcher {
    public static void main(String[] args) {
//        TransferService transferService = new TransferService(
//                new NostalgieConvertingService(30),
//                new StubAccountRepository());
    }
}

/**
 * Responsibilities:
 * - DI building by config
 * - Lifecycle management: scopes -> stateful!
 *
 * - AOP by spring
 * - AOP by dev
 *
 * - Modules: code-generation
 */

/**
<app>
<bean type="TransferService" name="">
    <bean type="NostalgieConvertingService" scope="singleton">
        <constructor-arg value="30" />
    </bean>
</bean>
</app>
*/