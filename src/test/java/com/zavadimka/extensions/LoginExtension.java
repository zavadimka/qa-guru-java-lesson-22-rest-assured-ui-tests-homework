package com.zavadimka.extensions;

import com.zavadimka.models.UserSuccessfulLoginRequestModel;
import com.zavadimka.models.UserSuccessfulLoginResponseModel;
import com.zavadimka.tests.TestUserData;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.zavadimka.specs.DemoQaApiSpecification.baseRequestSpec;
import static com.zavadimka.specs.DemoQaApiSpecification.userSuccessfulLoginResponseSpecWithStatusCode200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {

        TestUserData.getUserTestLoginData();

        UserSuccessfulLoginRequestModel userLoginData = new UserSuccessfulLoginRequestModel();
        userLoginData.setUserName(TestUserData.userName);
        userLoginData.setPassword(TestUserData.password);

        UserSuccessfulLoginResponseModel response = step("### Make Post Login request to API to get Authorized User cookies", () ->
                given()
                        .spec(baseRequestSpec)
                        .body(userLoginData)
                        .when()
                        .post("/Account/v1/Login")
                        .then()
                        .spec(userSuccessfulLoginResponseSpecWithStatusCode200)
                        .extract().as(UserSuccessfulLoginResponseModel.class)
        );

        step("### Add Authorized User cookies", () -> {
            open("/favicon.ico");
            addCookie("userID", response.getUserId());
            addCookie("token", response.getToken());
            addCookie("expires", response.getExpires());
        });
    }

    private void addCookie(String name, String cookie) {
        getWebDriver().manage().addCookie(
                new Cookie(name, cookie)
        );
    }
}
