package br.com.harisson.devdojotest.mapper.enums;

public enum CreditDebitIndicator {
    DEBIT("DEBIT"),
    CREDIT("CREDIT");

    private final String baseStringCreditDebitIndicator;

    CreditDebitIndicator(String creditDebitIndicator){
        this.baseStringCreditDebitIndicator = creditDebitIndicator;
    }

    public String getCreditDebitIndicator(){
        return baseStringCreditDebitIndicator;
    }
}
