package com.amazon.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props;

    static {
        try (FileInputStream fis = new FileInputStream("./src/test/resources/config/config.qa.properties")) {
            props = new Properties();
            props.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
