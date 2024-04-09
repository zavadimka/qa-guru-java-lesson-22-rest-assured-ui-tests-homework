package com.zavadimka.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BookList {

    private static final SelenideElement bookListRow = $("div.rt-table div.rt-tbody div.rt-tr-group");
    private static final SelenideElement emptyBookListNoDataField = $(".rt-noData");
    private static final String noDataFieldText = "No rows found";

    public static void checkEmptyBookList() {
        bookListRow.shouldBe(empty);
        emptyBookListNoDataField.shouldBe(visible)
                .shouldHave(text(noDataFieldText));
    }
}
