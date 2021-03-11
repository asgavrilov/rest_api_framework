package com.student.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader propertyInstance;

    private PropertyReader() {
    }

    public static synchronized PropertyReader getInstance() {

        if (propertyInstance == null) {
            propertyInstance = new PropertyReader();
        }
        return propertyInstance;
    }

    public String getProperty(String propertyName) {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass().
                    getClassLoader().
                    getResourceAsStream("application.properties");
            prop.load(inputStream);

            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
