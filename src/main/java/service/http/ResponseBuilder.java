package service.http;


import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.lang.reflect.Method;

public class ResponseBuilder {
	private static Logger logger = Logger.getLogger(ResponseBuilder.class);
	public static <T> T fromJson(Class<T> returnType, String json) {
		if(logger.isTraceEnabled()){
			logger.trace("Json from response is: "+json);
		}
		if(returnType.equals(String.class)){
			return (T)json;
		}else if(json != null && json.trim().length() > 0){
			ObjectMapper m = new ObjectMapper();
			m.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
			m.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
			m.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			m.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
			m.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
			m.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			m.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
			try {
				if(logger.isTraceEnabled()){
					logger.trace("try to restore the class with root wraper");
				}
				return m.readValue(json, returnType);
			} catch (Exception e) {
				if(logger.isTraceEnabled()){
					logger.trace(e.getMessage());
				}
			}

			try {
				if(logger.isTraceEnabled()){
					logger.trace("try another method, try to restore the class without root wraper");
				}
				m.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
				m.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,false);
				return m.readValue(json, returnType);
			} catch (Exception e) {
				if(logger.isTraceEnabled()){
					logger.trace(e.getMessage());
				}
			}

			try {
				if(logger.isTraceEnabled()){
					logger.trace("try another method, try to build error message from plain text");
				}
				ResponseMessage result = new ResponseMessage();
				m.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,false);
				JsonNode rootNode = m.readTree(json);
				String rootCause = rootNode.getFieldNames().next();
				result.setRootCause(rootCause);
				result.setErrorMessage(rootNode.get(rootCause).path("message")
						.getTextValue());
				result.setErrorStatusCode(String.valueOf(rootNode
						.get(rootCause).path("code").getIntValue()));
				result.setFullErrorMessage(json);
				if(returnType.equals(ResponseMessage.class)){
					return (T) result;
				}else{
					return convert(returnType, result);
				}
			} catch (Exception e) {
				if(logger.isTraceEnabled()){
					logger.trace(e.getMessage());
				}
				logger.error("tried all the method and failed to restore the message.");
			}
		}
		return null;
	}
	
	private static <T, R> T convert(Class<T> type, R raw) {
        if (raw == null) {
            return null;
        }
        try {
        	T des = type.newInstance();
            Method[] desMs = type.getSuperclass().getDeclaredMethods();
            Method[] rawMs = raw.getClass().getDeclaredMethods();
            for (Method m : rawMs) {
                String mn = m.getName();
                if (mn.contains("get")
                        && !mn.equals("equals")
                        && !mn.equals("toString")
                        && !mn.equals("hashCode")) {
                        for(Method d : desMs){
                            String dn = d.getName();
                            if (dn.contains("set")
                                    && !dn.equals("equals")
                                    && !dn.equals("toString")
                                    && !dn.equals("hashCode")) {
                                if(mn.substring(3).equals(dn.substring(3))){
                                    d.invoke(des, m.invoke(raw));
                                }
                            }
                        }
                }
            }
            return des;
        } catch (Exception e) {
        	logger.error(e);
        }
        return null;
    }
}
