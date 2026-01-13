package com.amazon.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties props;

    static {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\durge\\eclipse-workspace\\amazonAutomation\\src\\test\\resources\\config.properties")) {
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
