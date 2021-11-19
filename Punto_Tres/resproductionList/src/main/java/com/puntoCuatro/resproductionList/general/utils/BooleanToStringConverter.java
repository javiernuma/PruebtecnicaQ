package com.puntoCuatro.resproductionList.general.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return (value == null || !value) ? "N" : "S";
    }

    @Override
    public Boolean convertToEntityAttribute(String value) {
        return "S".equals(value);
    }
}
