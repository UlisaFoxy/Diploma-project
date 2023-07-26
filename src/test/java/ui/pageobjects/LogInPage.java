package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    private final SelenideElement userNameField = $("#form-username");
    private final SelenideElement passwordField = $("#form-password");
    private final SelenideElement submitButton = $("button[type=submit]");

    @Step("The user logs in")
    public DashboardPage logIn(String userName, String password) {
        getUserNameField().shouldBe(Condition.visible).sendKeys(userName);
        getPasswordField().shouldBe(Condition.visible).sendKeys(password);
        getSubmitButton().shouldBe(Condition.visible).click();
        return new DashboardPage();
    }

    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getSubmitButton() {
        return submitButton;
    }
}
