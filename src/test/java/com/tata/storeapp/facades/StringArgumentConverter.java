package com.tata.storeapp.facades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
public class StringArgumentConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object sourceType, Class<?> targetType) {
        assertEquals(String.class, targetType, "It will only convert to String");
        if (sourceType instanceof Enum<?>) {
            return ((Enum<?>) sourceType).name();
        }
        return String.valueOf(sourceType);
    }
}