package com.zavadimka.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Owner("Dmitry Zavada")
@Feature("Profile page Book List API and UI tests")
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("login_tests")})
public class LoginPageTests extends TestBase {

    @Test
    @Disabled
    @DisplayName("Profile page empty Book List API and UI tests")
    @Story("Open Profile page and check that the Book List is empty")
    @Severity(SeverityLevel.CRITICAL)
    void profilePageBookListShouldBeEmpty() {

        step("### Open Login page and check login header visibility and verify text", () -> {
            loginPage.openPage()
                    .checkloginHeader();
        });

        step("### Check the Login Form", () -> {
            loginPage.checkLoginFormVisibility();
        });
    }
}
