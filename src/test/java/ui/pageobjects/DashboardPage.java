package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {
    private final SelenideElement newProjectButton = $x("//div[@class='page-header']//ul/li[1]/a");
    private final SelenideElement projectNameField = $("#form-name");
    private final SelenideElement checkboxButton = $("input[type=checkbox]");
    private final SelenideElement taskLimitField = $x("//input[@name='task_limit']");
    private final SelenideElement saveButton = $("button[type=submit]");


    public DashboardPage newProjectButton() {
        getNewProjectButton().shouldBe(Condition.visible).click();
        return this;

    }

    @Step("The user create the project")
    public BoardPage setUpNewProject(String projectName, String taskLimit) {
        getProjectNameField().shouldBe(Condition.visible).sendKeys(projectName);
        getCheckboxButton().shouldBe(Condition.visible).click();
        getTaskLimitField().shouldBe(Condition.visible).sendKeys(taskLimit);
        getSaveButton().shouldBe(Condition.visible).click();
        return new BoardPage();
    }

    public SelenideElement getNewProjectButton() {
        return newProjectButton;
    }

    public SelenideElement getProjectNameField() {
        return projectNameField;
    }

    public SelenideElement getCheckboxButton() {
        return checkboxButton;
    }

    public SelenideElement getTaskLimitField() {
        return taskLimitField;
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }

}
