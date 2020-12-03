package br.com.harisson.devdojotest.mapper.util;

import br.com.harisson.devdojotest.endpoint.service.ApplicationUserService;
import br.com.harisson.devdojotest.endpoint.service.TransactionService;
import br.com.harisson.devdojotest.mapper.model.TransactionReceiver;
import br.com.harisson.devdojotest.model.ApplicationUser;
import br.com.harisson.devdojotest.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class JsonMapperUtil {

    private JsonMapperUtil(){

    }

    public static void saveTransactionListWithJsonArchive(TransactionService transactionService) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<TransactionReceiver>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/transactions.json");
        mapperJsonTransaction(mapper, inputStream, typeReference, transactionService);
    }

    private static void mapperJsonTransaction(ObjectMapper objectMapper, InputStream inputStream, TypeReference<List<TransactionReceiver>> typeReference, TransactionService transactionService) {
        try {
            List<TransactionReceiver> transactionReceiverList = objectMapper.readValue(inputStream, typeReference);
            transactionService.saveTransactionList(convertJsonListInTransactionList(transactionReceiverList));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Transaction> convertJsonListInTransactionList(List<TransactionReceiver> transactionReceiverList) {
        return transactionReceiverList.stream()
                .map(TransactionConverterUtil::convertTransactionReceiverToTransaction)
                .collect(Collectors.toList());
    }

    public static void saveApplicationUserListWithJsonArchive(ApplicationUserService applicationUserService) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<ApplicationUser>> typeReference = new TypeReference<>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/setup-users.json");
        mapperJsonApplicationUser(mapper, inputStream, typeReference, applicationUserService);
    }

    private static void mapperJsonApplicationUser(ObjectMapper objectMapper, InputStream inputStream, TypeReference<List<ApplicationUser>> typeReference, ApplicationUserService applicationUserService) {
        try {
            List<ApplicationUser> jsonApplicationUsersList = objectMapper.readValue(inputStream, typeReference);
            applicationUserService.saveApplicationUserList(jsonApplicationUsersList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
