package com.danylostasenko.unfollower.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtil {

    private final static String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    private final static String WINDOWS_CHROME_DRIVER_LOCATION = "C:\\Users\\Danylo\\Documents\\github-unfollower\\chromedriver_v74.exe"; // todo: set Your location
    private final static String WINDOWS_CHROME_PROFILE_PATH = "C:\\Users\\Danylo\\AppData\\Local\\Google\\Chrome\\User Data";   // todo: load user from system
    private final static String CHROME_USER_DATA_DIR = "--user-data-dir=";

    public static WebDriver getDriver() {
        System.setProperty(CHROME_DRIVER_NAME, WINDOWS_CHROME_DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments(CHROME_USER_DATA_DIR + WINDOWS_CHROME_PROFILE_PATH);

        return new ChromeDriver(options);
    }
}
