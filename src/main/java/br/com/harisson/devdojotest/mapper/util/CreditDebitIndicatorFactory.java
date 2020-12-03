package br.com.harisson.devdojotest.mapper.util;

import static br.com.harisson.devdojotest.mapper.enums.CreditDebitIndicator.CREDIT;
import static br.com.harisson.devdojotest.mapper.enums.CreditDebitIndicator.DEBIT;

public class CreditDebitIndicatorFactory {

    private CreditDebitIndicatorFactory() {
    }

    public static String getStatusAmount(Double amount) {
        if (amount < 0) {
            return DEBIT.getCreditDebitIndicator();
        }
        return CREDIT.getCreditDebitIndicator();
    }
}
