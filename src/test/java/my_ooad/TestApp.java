package my_ooad;

import com.acme.banking.dbo.my_ooad.ReportingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test,prod");
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-spring-context.xml", "my-spring-context.xml")) {

            //ReportingService reportingService = (ReportingService) context.getBean("reportingService");
            ReportingService reportingService = context.getBean(ReportingService.class);
            System.out.println(">>>>> " + reportingService.getUsdAmountFor(1L));

            //AccountRepository accountRepository = context.getBean("accountRepository", AccountRepository.class);
            //accountRepository.saveAndFlush(new SavingAccount(0, "correct@mail.ru"));

            //Move to spring-context and Show Diagram...
        }
       /* ReportingService reportingService = new ReportingService(
                new NostalgieXchangeService(30), new AccountRepository()
        );

        Collection<Account> accounts = reportingService.getAllAccountsInUsd();
        accounts.forEach(
                a -> System.out.println(a.getAmount())
        );*/
    }
}

