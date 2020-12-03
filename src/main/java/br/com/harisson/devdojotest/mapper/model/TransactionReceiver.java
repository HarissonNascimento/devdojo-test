package br.com.harisson.devdojotest.mapper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embedded;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionReceiver {

    private String encodedKey;
    private String parentAccountKey;
    private String creationDate;
    private String type;
    private String valueDate;
    private Double amount;
    private String currencyCode;
    private String creditDebitIndicator;
    private String id;
    private String userKey;
    @Embedded
    private TotalBalanceReceiver accountBalances;
}
