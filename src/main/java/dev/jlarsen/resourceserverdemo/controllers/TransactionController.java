package dev.jlarsen.resourceserverdemo.controllers;


import dev.jlarsen.resourceserverdemo.models.Transaction;
import dev.jlarsen.resourceserverdemo.models.TransactionList;
import dev.jlarsen.resourceserverdemo.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "localhost")
public class TransactionController {

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    TransactionService transactionService;

    @GetMapping(value = "/public")
    public String publicEndpoint() {
        return "Success, this is a public endpoint!";
    }


    @GetMapping(value = "/private")
    public String privateEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return "Success, this is a private endpoint!";
    }

    @GetMapping(value = "/transactions")
    public TransactionList privateScopedEndpoint(@AuthenticationPrincipal Jwt jwt) {

        String accountName = jwt.getClaimAsString("sub");
        String accountNumber = jwt.getClaimAsString("accountNo");

        List<Transaction> transactions = transactionService.getAll(accountNumber);

        return TransactionList.builder()
                .withAccountName(accountName)
                .withAccountNumber(accountNumber)
                .withTransactions(transactions)
                .build();
    }
}