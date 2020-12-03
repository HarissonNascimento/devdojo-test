package br.com.harisson.devdojotest.endpoint.repository;

import br.com.harisson.devdojotest.model.Transaction;
import br.com.harisson.devdojotest.util.TransactionCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayName("Transaction Repository Tests")
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    @DisplayName("Find transaction by userKey return listTransactions when successful")
    void findTransactionsByUserKey_ReturnListTransactions_WhenSuccessful(){
        String expectedUserKey = TransactionCreator.createValidTransaction().getUserKey();

        List<Transaction> transactionList = transactionRepository.findTransactionByUserKey(expectedUserKey);

        Assertions.assertThat(transactionList).isNotNull();

        Assertions.assertThat(transactionList.isEmpty()).isFalse();

        Assertions.assertThat(transactionList.get(0).getUserKey()).isEqualTo(expectedUserKey);
    }
}
