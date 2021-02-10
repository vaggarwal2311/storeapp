package com.tata.storeapp.models;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private long transactionId;
//    @Getter(value=AccessLevel.NONE)
    private long amount;
    private TransactionType transactionType;
    private LocalDate dot;

}
