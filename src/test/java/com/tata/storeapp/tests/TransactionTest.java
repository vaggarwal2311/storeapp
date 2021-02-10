package com.tata.storeapp.tests;

import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Random;

public class TransactionTest {
    private Transaction transaction1,transaction2,transaction3;

    @BeforeEach
    public void getInstance(){
        transaction1=new Transaction();
        transaction1.setTransactionId(new Random().nextInt(10));
        transaction2=new Transaction();
        transaction2.setTransactionId(new Random().nextInt(10));
    }

    @Test
    @DisplayName("Test Transaction Id to be unique")
    public void testTransactionIdUnique(){
        assertNotEquals(transaction1.getTransactionId(),transaction2.getTransactionId());
    }

    @ParameterizedTest
    @ValueSource(ints = {1234,12345,-123456,8976})
    @DisplayName("Test Amount to be greater than zero")
    public void testAmountToBePositive(int data)
    {
        transaction1.setAmount(data);
        assertTrue(transaction1.getAmount()>0);
    }

    //negative test case nullpointer exp
    @Test()
    public void negativeTestForTransactionInstance()
    {
        assertThrows(NullPointerException.class,()->{transaction3.getTransactionId();
        });
    }

    @ParameterizedTest
    @CsvFileSource(resources = "transactiondata.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(int transactionId, int amount) {
        assertTrue(transactionId>0);
        assertNotEquals(0, amount);
    }

    @RepeatedTest(5)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
//        assertEquals(5, repetitionInfo.getTotalRepetitions());
          assertNotEquals(transaction1.getTransactionId(),transaction2.getTransactionId());

    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("Repeat!")
    void transactionDisplayName(TestInfo testInfo,RepetitionInfo repetitionInfo) {
        assertEquals("Repeat! "+repetitionInfo.getCurrentRepetition()+"/"+repetitionInfo.getTotalRepetitions(), testInfo.getDisplayName());
    }

    @Disabled
    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("Details...")
    void customDisplayNameWithLongPattern(TestInfo testInfo) {
        assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
    }
}
