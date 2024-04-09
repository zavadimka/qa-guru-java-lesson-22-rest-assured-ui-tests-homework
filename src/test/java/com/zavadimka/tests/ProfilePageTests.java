package com.zavadimka.tests;

import com.zavadimka.tests.extensions.WithLogin;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;

@Owner("Dmitry Zavada")
@Feature("Profile page Book List API and UI tests")
@Tags({@Tag("rest_api"), @Tag("rest_assured"), @Tag("profile_tests")})
public class ProfilePageTests extends TestBase {

    @Test
    @WithLogin
    @DisplayName("Profile page empty Book List API and UI tests")
    @Story("Open Profile page and check that the Book List is empty")
    @Severity(SeverityLevel.CRITICAL)
    void profilePageBookListShouldBeEmpty() {

        step("### Open Profile page and verify page title", () -> {
            profilePage.openPage()
                            .verifyPageTitle();
        });

        step("### Check the Book List", () -> {
            profilePage.checkEmptyBookList();
        });
    }
}
