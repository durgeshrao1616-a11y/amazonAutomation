package com.amazon.constants;

public class Constants {

    // ==============================
    // Project / Framework Settings
    // ==============================
    public static final String PROJECT_NAME = "Hybrid Automation Framework";
    public static final String VERSION = "1.0.0";

    // ==============================
    // Paths
    // ==============================
    public static final String BASE_DIR = System.getProperty("user.dir");
    public static final String CONFIG_FILE = BASE_DIR + "/src/test/resources/config.properties";
    public static final String TEST_DATA_FILE = BASE_DIR + "/src/test/resources/testdata.xlsx";
    public static final String REPORTS_DIR = BASE_DIR + "/reports/";
    public static final String SCREENSHOTS_DIR = REPORTS_DIR + "screenshots/";

    // ==============================
    // Browser / Driver Settings
    // ==============================
    public static final String CHROME_DRIVER_PATH = BASE_DIR + "/drivers/chromedriver.exe";
    public static final String FIREFOX_DRIVER_PATH = BASE_DIR + "/drivers/geckodriver.exe";
    public static final int DEFAULT_TIMEOUT = 30; // seconds
    public static final int PAGE_LOAD_TIMEOUT = 60; // seconds

    // ==============================
    // URLs
    // ==============================
    public static final String BASE_URL = "https://example.com";
    public static final String LOGIN_URL = BASE_URL + "/login";
    public static final String DASHBOARD_URL = BASE_URL + "/dashboard";

    // ==============================
    // Credentials (better to load from config)
    // ==============================
    public static final String DEFAULT_USERNAME = "testuser";
    public static final String DEFAULT_PASSWORD = "password123";

    // ==============================
    // Reporting
    // ==============================
    public static final String ALLURE_RESULTS_DIR = BASE_DIR + "/allure-results/";
    public static final String EXTENT_REPORT_FILE = REPORTS_DIR + "ExtentReport.html";

    // ==============================
    // Miscellaneous
    // ==============================
    public static final String DATE_FORMAT = "yyyy-MM-dd_HH-mm-ss";
}
