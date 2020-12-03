package br.com.harisson.devdojotest.endpoint.controller;

import br.com.harisson.devdojotest.endpoint.service.TransactionService;
import br.com.harisson.devdojotest.model.ApplicationUser;
import br.com.harisson.devdojotest.model.Transaction;
import br.com.harisson.devdojotest.util.ApplicationUserCreator;
import br.com.harisson.devdojotest.util.TransactionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(SpringExtension.class)
class TransactionControllerTest {
    @InjectMocks
    private TransactionController transactionController;

    @Mock
    private TransactionService transactionServiceMock;

    @BeforeEach
    public void setUp(){

        BDDMockito.when(transactionServiceMock.listTransactionsByUserKey(anyString()))
                .thenReturn(TransactionCreator.createValidListTransaction());

    }

    @Test
    @DisplayName("List all user transactions when successful")
    void listAllUserTransactions_WhenSuccessful(){
        String expectedId = TransactionCreator.createValidTransaction().getId();

        ApplicationUser applicationUser = ApplicationUserCreator.createValidApplicationUser();

        List<Transaction> transactionList = transactionController.findTransactionsByAccountId(applicationUser.getAccountId(), applicationUser).getBody();

        Assertions.assertThat(transactionList).isNotNull();

        Assertions.assertThat(transactionList.get(0).getId()).isEqualTo(expectedId);
    }
}
