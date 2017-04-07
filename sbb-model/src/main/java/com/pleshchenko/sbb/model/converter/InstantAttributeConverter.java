package com.pleshchenko.sbb.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * Created by РОМАН on 07.04.2017.
 */
@Converter(autoApply = true)
public class InstantAttributeConverter implements AttributeConverter<Instant, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(final Instant dateTime) {
        return dateTime == null ? null : Timestamp.from(dateTime);
    }


    @Override
    public Instant convertToEntityAttribute(final Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toInstant();
    }
}