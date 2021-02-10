package com.tata.storeapp.utility;

import com.tata.storeapp.business.TransactionSorter;
import com.tata.storeapp.dao.TransactionDao;
import com.tata.storeapp.dao.TransactionImpl;
import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;

import java.util.Collections;
import java.util.List;

public class TransactionApp {
    public static void main(String[] args) {
//        Transaction transaction=new Transaction(12,1234, TransactionType.NETBANKING);
//        System.out.println(transaction.getTransactionId());
//        System.out.println(transaction.getAmount());
//        transaction.setAmount(123456);
//        System.out.println(transaction.getAmount());
//        System.out.println(transaction);

        TransactionDao transactionDao = new TransactionImpl();
        List<Transaction> transactionList=transactionDao.getAllTransaction();

        System.out.println("Before Sorting...");
        for(Transaction transaction : transactionList)
        {
            System.out.println(transaction);
        }

        //After Sorting...
        System.out.println("After Sorting...");
        Collections.sort(transactionList,new TransactionSorter());
        for(Transaction transaction : transactionList)
        {
            System.out.println(transaction);
        }

        //Second way of Sorting
        System.out.println("After Sorting 2...");
        transactionList.stream().sorted((t1,t2)->t1.getDot().compareTo(t2.getDot())).forEach(System.out::println);

    }
}
