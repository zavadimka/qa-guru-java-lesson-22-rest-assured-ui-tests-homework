package com.zavadimka.pages;

import com.codeborne.selenide.SelenideElement;
import com.zavadimka.pages.components.BookList;
import com.zavadimka.tests.TestUserData;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ProfilePage {

    public final String pageUrl = "/profile",
            pageTitle = "DEMOQA";
    public final SelenideElement userNameLabel = $("#userName-value");


    @Step("Open Profile Page")
    public ProfilePage openPage() {
        open(pageUrl);

        return this;
    }

    @Step("Verify Profile Page title")
    public ProfilePage verifyPageTitle() {
        assertThat(pageTitle).isEqualTo(title());

        return this;
    }

    @Step("Verify the UserName of the Authorized User")
    public ProfilePage verifyUserName() {
        assertThat(userNameLabel.getText()).isEqualTo(TestUserData.userName);

        return this;
    }

    @Step("Check that the Book List is visible, empty and has sign \"No rows found\"")
    public void checkEmptyBookList() {
        BookList.checkEmptyBookList();
    }
}
