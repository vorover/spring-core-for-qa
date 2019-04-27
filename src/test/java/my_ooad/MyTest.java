package my_ooad;

import com.acme.banking.dbo.my_ooad.Account;
import com.acme.banking.dbo.my_ooad.AccountRepository;
import com.acme.banking.dbo.my_ooad.ReportingService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(SpringRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml", "classpath:my-spring-context.xml"})
@ActiveProfiles("test")
public class MyTest {
    @Autowired
    private ReportingService reportingService;
    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void shouldUseStubWithinSpringContext() {
        Account accountStub = mock(Account.class);
        when(accountStub.getAmount()).thenReturn(10_000d);
        when(accountRepository.getAccount(anyLong())).thenReturn(accountStub);

        assertThat(reportingService.getUsdAmountFor(0L)).isEqualTo(10_000d/30);
    }

    @Test
    public void shouldReturnAllAccountsIfNonEmptyRepository() {
        Account accountStub1 = mock(Account.class);
        when(accountStub1.getAmount()).thenReturn(10_000d);
        when(accountRepository.getAccount(1)).thenReturn(accountStub1);
        Account accountStub2 = mock(Account.class);
        when(accountStub2.getAmount()).thenReturn(20_000d);
        when(accountRepository.getAccount(2)).thenReturn(accountStub2);
        Collection<Account> accounts = new ArrayList<>();
        accounts.add(accountStub1);
        accounts.add(accountStub2);
        when(accountRepository.getAllAccounts()).thenReturn(accounts);

        assertThat(reportingService.getUsdAmountFor(1L)).isEqualTo(10_000d/30);
        assertThat(reportingService.getUsdAmountFor(2L)).isEqualTo(20_000d/30);

        assertThat(reportingService.getAllAccountsInUsd().size()).isEqualTo(2);
    }

    @Test
    public void shouldReturnZeroAccountsIfEmptyRepository() {
        Collection<Account> accounts = new ArrayList<>();
        when(accountRepository.getAllAccounts()).thenReturn(accounts);
        assertThat(reportingService.getAllAccountsInUsd().size()).isEqualTo(0);
    }
}
