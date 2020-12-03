package br.com.harisson.devdojotest.endpoint.controller;

import br.com.harisson.devdojotest.endpoint.service.TransactionService;
import br.com.harisson.devdojotest.model.ApplicationUser;
import br.com.harisson.devdojotest.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping(path = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("#accountId == #applicationUser.accountId")
    public ResponseEntity<List<Transaction>> findTransactionsByAccountId(@PathVariable Long accountId,
                                                                         @AuthenticationPrincipal ApplicationUser applicationUser){
        return ResponseEntity.ok(transactionService.listTransactionsByUserKey(applicationUser.getUserKey()));
    }
}
