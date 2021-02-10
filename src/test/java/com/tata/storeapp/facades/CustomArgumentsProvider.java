package com.tata.storeapp.facades;

import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
//public class CustomArgumentsProvider implements ArgumentsProvider {

//    @Override
//    public Stream<? extends Arguments>
//    provideArguments(ExtensionContext extensionContext) throws Exception {
//        return Stream.of("java", "rust", "kotlin").map(Arguments::of);
//    }

    public class CustomArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments>
        provideArguments(ExtensionContext extensionContext) throws Exception {

            Transaction transaction=null;
            List<Transaction> transactionList=new ArrayList<Transaction>();
            for(int i=0;i<10;i++){

                transaction=new Transaction();
                transaction.setTransactionId(new Random().nextInt(1000000));
                transaction.setAmount(new Random().nextInt(1000000));
                transaction.setDot(LocalDate.of(1990+new Random().nextInt(25),1+new Random().nextInt(10),1+new Random().nextInt(27) ));
                transaction.setTransactionType(TransactionType.NETBANKING);
                transactionList.add(transaction);
            }

            return transactionList.stream().map(Arguments::of);
        }
    }
