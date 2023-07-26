package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateTaskPage {

    private final SelenideElement title = $x("//input[@name='title']");
    private final SelenideElement description = $x("//textarea[@name='description']");
    private final SelenideElement priority = $x("//select[@name='priority']");
    private final SelenideElement saveButton = $("button[type=submit]");

    @Step("The user create the task")
    public BoardPage createNewTask(String tittle,String description, String priority) {
        getTitle().shouldBe(Condition.visible).sendKeys(tittle);
        getDescription().shouldBe(Condition.visible).sendKeys(description);
        getPriority().shouldBe(Condition.visible).sendKeys(priority);
        getSaveButton().shouldBe(Condition.visible).click();
        return new BoardPage();

    }

    public SelenideElement getTitle() {
        return title;
    }

    public SelenideElement getDescription() {
        return description;
    }

    public SelenideElement getPriority() {
        return priority;
    }

    public SelenideElement getSaveButton() {
        return saveButton;
    }
}
