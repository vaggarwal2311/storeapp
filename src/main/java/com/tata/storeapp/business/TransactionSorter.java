package com.tata.storeapp.business;

import com.tata.storeapp.models.Transaction;

import java.util.Comparator;

public class TransactionSorter implements Comparator<Transaction> {
    @Override
    public int compare(Transaction o1, Transaction o2) {
        return o1.getDot().compareTo(o2.getDot());
    }
}
