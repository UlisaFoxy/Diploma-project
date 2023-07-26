package ui.pageobjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BoardPage {
    private final SelenideElement newTaskButton = $("div.board-add-icon a.js-modal-large i.fa.fa-plus.fa-fw.js-modal-large[aria-hidden='true']");
    private final SelenideElement theTaskName = $x("//div[@class='task-board-title']/a[text()='My new Task']");
    private final SelenideElement titleTask = $x("//div[@class='task-board-title']/a");
    private final SelenideElement boardTab = $x("//a[contains(@title, 'Keyboard shortcut: \"v b\"')]");
    private final SelenideElement description = $x("//ul[@class='panel']/li/strong[text()='This project is open']");

    @Step("The user push the button plus (create new task)")
    public CreateTaskPage pushTheNewTaskButton() {
        getNewTaskButton().shouldBe(Condition.visible).click();
        return new CreateTaskPage();
    }

    @Step("The user go to the task page")
    public TaskPage goToTaskPage() {
        getTitleTask().shouldBe(Condition.visible).click();
        return new TaskPage();

    }

    @Step("The user go to the board page")
    public BoardPage clickBoardTab() {
        getBoardTab().shouldBe(Condition.visible).click();
        return new BoardPage();
    }

    public SelenideElement getBoardTab() {
        return boardTab;
    }

    public SelenideElement getTitleTask() {
        return titleTask;
    }

    public SelenideElement getNewTaskButton() {
        return newTaskButton;
    }

    public SelenideElement getTheTaskName() {
        return theTaskName;
    }

    public SelenideElement getDescription() {
        return description;
    }
}
