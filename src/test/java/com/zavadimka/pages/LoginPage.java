package com.zavadimka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {


    private final String pageUrl = "/login";
    private final String loginHeaderText = "Login";

    private final SelenideElement loginHeader = $(".text-center"),
            loginForm = $("#userForm");


    @Step("### Open Profile Page")
    public LoginPage openPage() {
        open(pageUrl);

        return this;
    }

    @Step("### Check login header visibility and verify text")
    public LoginPage checkloginHeader() {
        loginHeader.shouldBe(visible)
                .shouldHave(text(loginHeaderText));

        return this;
    }

    @Step("### Check that User is not Logged In")
    public LoginPage checkLoginFormVisibility() {
        loginForm.shouldBe(visible);

        return this;
    }
}
