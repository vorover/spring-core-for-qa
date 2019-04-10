package com.acme.banking.dbo.spring.service;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml", "classpath:spring-context.xml"})
@ActiveProfiles("test")
public class DemoIntegrationTestWithSpringBootTest {
    @Autowired private ReportingService reportingService;
    @MockBean private AccountRepository accountRepository;

    @Test
    public void shouldUseStubWithinSpringContext() {
        Account accountStub = mock(Account.class);
        when(accountStub.getAmount()).thenReturn(10_000d);
        when(accountRepository.findById(anyLong())).thenReturn(Optional.of(accountStub));

        assertThat(reportingService.getUsdAmountFor(0L)).isEqualTo(300000d);
    }
}
