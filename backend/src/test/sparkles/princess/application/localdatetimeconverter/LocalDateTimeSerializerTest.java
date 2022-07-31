package sparkles.princess.application.localdatetimeconverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Johnny Cold
 */
public class LocalDateTimeSerializerTest {

    @Test
    public void serialiseLocalDateTimeToJSON(){
        LocalDateTime dateTime = LocalDateTime.MIN;
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();
        String dateTimeInJSON = gson.toJson(dateTime);
        System.out.println(dateTimeInJSON);
        assertEquals("\"-999999999-01-01T00:00:00\"", dateTimeInJSON);
    }
}
