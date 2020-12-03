package br.com.harisson.devdojotest.mapper.util;

import br.com.harisson.devdojotest.mapper.model.TransactionReceiver;
import br.com.harisson.devdojotest.model.Transaction;

import static br.com.harisson.devdojotest.mapper.util.CreditDebitIndicatorFactory.getStatusAmount;

public class TransactionConverterUtil {
    private TransactionConverterUtil() {
    }

    public static Transaction convertTransactionReceiverToTransaction(TransactionReceiver transactionReceiver){
        return Transaction.builder()
                .id(transactionReceiver.getEncodedKey())
                .arrangementId(transactionReceiver.getParentAccountKey())
                .bookingDate(transactionReceiver.getCreationDate())
                .type(transactionReceiver.getType())
                .valueDate(transactionReceiver.getValueDate())
                .amount(transactionReceiver.getAmount())
                .currencyCode(transactionReceiver.getCurrencyCode())
                .currency(transactionReceiver.getCurrencyCode())
                .creditDebitIndicator(getStatusAmount(transactionReceiver.getAmount()))
                .runningBalance(transactionReceiver.getAccountBalances().getTotalBalance())
                .counterPartyAccountNumber(transactionReceiver.getId())
                .reference(transactionReceiver.getParentAccountKey())
                .typeGroup(transactionReceiver.getType())
                .instructedAmount(transactionReceiver.getAmount())
                .userKey(transactionReceiver.getUserKey())
                .build();
    }
}
