package com.tata.storeapp.dao;

import com.tata.storeapp.models.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction>getAllTransaction();
}
