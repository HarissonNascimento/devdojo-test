package br.com.harisson.devdojotest;

import br.com.harisson.devdojotest.endpoint.service.ApplicationUserService;
import br.com.harisson.devdojotest.endpoint.service.TransactionService;
import br.com.harisson.devdojotest.model.Transaction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DevdojoTestApplicationTests {
    @InjectMocks
    private DevdojoTestApplication devdojoTestApplication;

    @Mock
    private ApplicationUserService applicationUserServiceMock;

    @Mock
    private TransactionService transactionServiceMock;

    @Test
    void contextLoads() {
        Assertions.assertThatCode(() ->devdojoTestApplication.runnerApplicationUser(applicationUserServiceMock))
                .doesNotThrowAnyException();

        Assertions.assertThatCode(() ->devdojoTestApplication.runnerTransaction(transactionServiceMock))
                .doesNotThrowAnyException();

    }

}
