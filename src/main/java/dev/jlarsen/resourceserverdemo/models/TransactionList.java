package dev.jlarsen.resourceserverdemo.models;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
public class TransactionList {

    private final String accountName;
    private final String accountNumber;
    private final List<Transaction> transactions;

}
