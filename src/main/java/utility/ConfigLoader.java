package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    public static String loadProperties(String prop) {
    	Properties properties =new Properties();
        try (FileInputStream fis = new FileInputStream("src/main/resources/WebConfiguration/webconfig.properties")) {
        	properties.load(fis);
        	return properties.getProperty(prop);      
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Return null if the property is not found or an exception occurs
    }
}