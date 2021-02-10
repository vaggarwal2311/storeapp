package com.tata.storeapp.tests;

import com.google.common.base.Strings;
import com.tata.storeapp.facades.CustomArgumentsProvider;
import com.tata.storeapp.facades.StringArgumentConverter;
import com.tata.storeapp.models.Transaction;
import com.tata.storeapp.models.TransactionType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.time.temporal.ChronoUnit;
import java.util.EnumSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TransactionTypeTest {
    @ParameterizedTest
    @EnumSource(value = TransactionType.class, names = {"CARD", "WALLET"})
    void testWithEnumSourceTransactionTypeInclude(TransactionType transactionType) {
        assertTrue(EnumSet.of(TransactionType.CARD, TransactionType.WALLET).
                contains(transactionType));
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertTrue(Strings.isNullOrEmpty(input));
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @NullSource
    void test_null_source(String arg) {

        System.out.println("arg => "+arg);
        assertTrue(arg == null);
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0}")
    @EmptySource
    void test_empty_source(String arg) {

        System.out.println("arg => "+arg);
        assertTrue(arg.isEmpty());
    }


    static Stream<String> stringProvider() {

        return Stream.of("admin", "subscriber", "author","anonymous");
    }


    @ParameterizedTest
    @MethodSource("stringProvider")
    void testWith_MethodSource(String arg) {
        System.out.println("testWith_MethodSource(arg) => "+arg);
        assertNotNull(arg);
    }

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void testargcustom(Transaction arg)
    {
        assertTrue(arg.getAmount()>0);
    }

    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testCaseWithExplicitArgumentConversion(
            @ConvertWith(StringArgumentConverter.class) String arg) {

        assertNotNull(ChronoUnit.valueOf(arg));
    }
}