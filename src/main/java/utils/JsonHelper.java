package utils;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;

public class JsonHelper {
    private static Logger logger = Logger.getLogger(JsonHelper.class);

    private static ObjectMapper m = new ObjectMapper();

    public static <T> T fromJson(Class<T> returnType, String json) {
        try {
            return m.readValue(json, returnType);
        } catch (JsonParseException e) {
            logger.error(e.getMessage());
        } catch (JsonMappingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public static String toJson(Object o) {
        try {
            m.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
            return m.writeValueAsString(o);
        } catch (JsonGenerationException e) {
            logger.error(e.getMessage());
        } catch (JsonMappingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
