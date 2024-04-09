package com.zavadimka.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.zavadimka.drivers.WebDriverProvider;
import com.zavadimka.helpers.Attach;
import com.zavadimka.pages.LoginPage;
import com.zavadimka.pages.ProfilePage;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    ProfilePage profilePage = new ProfilePage();
    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUp() {

        WebDriverProvider.setWebDriverConfig();

        RestAssured.baseURI = Configuration.baseUrl;
        RestAssured.basePath = System.getProperty("basePath", "");

        WebDriverProvider.printWebDriverConfig();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
