package br.com.harisson.devdojotest.endpoint.repository;

import br.com.harisson.devdojotest.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findTransactionByUserKey(String userKey);
}
