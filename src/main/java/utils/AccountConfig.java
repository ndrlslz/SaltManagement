package utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AccountConfig {
    private static Map<String, String> map = new HashMap<String, String>();
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String MASTER = "master";

    static {
        map = new HashMap<>();
        Resource resource = new ClassPathResource("/account.properties");
        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
            Enumeration keys = properties.keys();

            while (keys.hasMoreElements()) {
                String currentKey = (String) keys.nextElement();
                String currentValue = properties.getProperty(currentKey);
                map.put(currentKey, currentValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUsername() {
        return map.get(USERNAME);
    }

    public static String getPassword() {
        return map.get(PASSWORD);
    }

    public static String getMaster() {
        return map.get(MASTER);
    }
}
