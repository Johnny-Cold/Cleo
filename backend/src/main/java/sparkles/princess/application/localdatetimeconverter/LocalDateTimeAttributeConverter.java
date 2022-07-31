package sparkles.princess.application.localdatetimeconverter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Converts LocalDateTime data to be persisted to the PostgreSQL database to a date datatype suppoerted by the database.
 * Automatically converts java.sql.Date read from the database to LocalDateTime.
 * Automatically converts LocalDateTime to java.sql.Date when persisting.
 *
 * @author Johnny Cold
 */
@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
        return (localDateTime != null) ? Timestamp.valueOf(localDateTime) : null;
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return (timestamp != null) ? timestamp.toLocalDateTime() : null;
    }
}
