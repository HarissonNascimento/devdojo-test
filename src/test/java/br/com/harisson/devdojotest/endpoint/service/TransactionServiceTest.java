package br.com.harisson.devdojotest.endpoint.service;

import br.com.harisson.devdojotest.endpoint.repository.TransactionRepository;
import br.com.harisson.devdojotest.model.Transaction;
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
class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepositoryMock;

    @BeforeEach
    public void setUp(){
        BDDMockito.when(transactionRepositoryMock.findTransactionByUserKey(anyString()))
                .thenReturn(TransactionCreator.createValidListTransaction());
    }

    @Test
    @DisplayName("saveTransactionList returns void when successful")
    void saveTransactionList_ReturnsVoid_WhenSuccessful(){
        List<Transaction> listToBeSaved = TransactionCreator.createValidListTransaction();

        Assertions.assertThatCode(() -> transactionService.saveTransactionList(listToBeSaved))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Find transaction by userKey returns listTransactions when successful")
    void findTransactionByUserKey_ReturnsListTransactions_WhenSuccessful(){
        String expectedUserKey = TransactionCreator.createValidTransaction().getUserKey();

        List<Transaction> transactionList = transactionService.listTransactionsByUserKey(expectedUserKey);

        Assertions.assertThat(transactionList).isNotNull();

        Assertions.assertThat(transactionList.isEmpty()).isFalse();

        Assertions.assertThat(transactionList.get(0).getUserKey()).isEqualTo(expectedUserKey);
    }
}
