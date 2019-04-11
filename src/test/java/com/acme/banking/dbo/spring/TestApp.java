package com.acme.banking.dbo.spring;

import com.acme.banking.dbo.spring.dao.AccountRepository;
import com.acme.banking.dbo.spring.domain.SavingAccount;
import com.acme.banking.dbo.spring.service.ReportingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "test,prod"); //-Dspring.profiles.active="test,prod"
        /** ApplicationContext vs BeanFactory: https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#context-introduction-ctx-vs-beanfactory */
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-spring-context.xml", "spring-context.xml")) {

            ReportingService reportingService = (ReportingService) context.getBean("reportingService");
            System.out.println(">>>>> " + reportingService.getUsdAmountFor(1L));

            AccountRepository accountRepository = context.getBean("accountRepository", AccountRepository.class);
            accountRepository.saveAndFlush(new SavingAccount(0, "correct@mail.ru"));

            //Move to spring-context and Show Diagram...
        }
    }
}
