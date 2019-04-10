package com.acme.banking.dbo.spring;

import com.acme.banking.dbo.spring.service.ReportingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration({"classpath:test-spring-context.xml", "classpath:spring-context.xml"})
@TestPropertySource("classpath:app.properties")
public class DemoTest {
    @Autowired private ReportingService reportingService;
    @Autowired ApplicationContext context;

    @Test
    public void shouldCreateContext() {
        assertThat(reportingService.getUsdAmountFor(1)).isEqualTo(30);
    }
}
