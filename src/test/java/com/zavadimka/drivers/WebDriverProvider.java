package com.zavadimka.drivers;

import com.zavadimka.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Configuration.*;

public class WebDriverProvider {

    private static String driver;
    static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static void setWebDriverConfig() {

        getWebDriverDestination();
        driver = System.getProperty("driver");

        baseUrl = webDriverConfig.getDriverBaseUrl();
        browser = webDriverConfig.getBrowserName();
        browserVersion = webDriverConfig.getBrowserVersion();
        browserSize = webDriverConfig.getBrowserSize();

        switch (driver) {
            case "remote": {
                remote = webDriverConfig.getDriverRemoteUrl();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("selenoid:options", Map.<String, Object>of("enableVNC", true, "enableVideo", true));
                browserCapabilities = capabilities;
            }
            case "local": {
                pageLoadStrategy = "eager";
                pageLoadTimeout = 100_000;
                timeout = 10_000;
            }
        }
    }

    private static void getWebDriverDestination() {
        String driver = System.getProperty("driver", "remote");
        System.setProperty("driver", driver);
    }

    public static void printWebDriverConfig() {
        System.out.println("The test is run with the following WebDriver parameters:");
        System.out.printf("WebDriver: %s\n" + "Remote URL: %s\n" + "Base URL: %s\n" + "Browser: %s\n" + "Version: %s\n" + "Window size: %s%n", driver, remote, baseUrl, browser, browserVersion, browserSize);
    }
}
