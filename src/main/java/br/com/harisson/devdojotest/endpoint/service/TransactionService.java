package br.com.harisson.devdojotest.endpoint.service;

import br.com.harisson.devdojotest.endpoint.repository.TransactionRepository;
import br.com.harisson.devdojotest.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public void saveTransactionList(List<Transaction> transactionList){
        transactionRepository.saveAll(transactionList);
    }

    public List<Transaction> listTransactionsByUserKey(String userKey){
        return transactionRepository.findTransactionByUserKey(userKey);
    }
}
