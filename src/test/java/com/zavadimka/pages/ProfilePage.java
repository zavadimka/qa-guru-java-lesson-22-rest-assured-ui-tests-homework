package com.zavadimka.pages;

import com.zavadimka.pages.components.BookList;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {

    public final String pageUrl = "/profile";
    public final String pageTitle = "DEMOQA";


    @Step("Open Profile Page")
    public ProfilePage openPage() {
        open(pageUrl);

        return this;
    }

    @Step("Verify Profile Page title")
    public ProfilePage verifyPageTitle() {
        Assertions.assertEquals(pageTitle, title());

        return this;
    }

    @Step("Check that the Book List is visible, empty and has sign \"No rows found\"")
    public void checkEmptyBookList() {
        BookList.checkEmptyBookList();
    }
}
