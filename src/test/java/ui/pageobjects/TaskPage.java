package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPage {
    private final SelenideElement addCommentBTn = $x("//a[contains(text(), 'Add a comment')]");
    private final SelenideElement addCommentField = $x("//*[@id='modal-content']/form/div[1]/div/div[2]/textarea");
    private final SelenideElement submitCommentBtn = $x("//*[@id='modal-content']/form/div[2]/div/button");
    private final SelenideElement theCommentName = $x("//div[@class='markdown']/p[contains(text(),'My first comment')]");
    private final SelenideElement closeTaskBtn = $x("//a[contains(text(), 'Close this task')]");
    private final SelenideElement yesBtn = $x("//*[@id='modal-confirm-button']");
    private final SelenideElement statusTask = $x("//div[@class='task-summary-column']//ul[@class='no-bullet']/li[1]/span");

    @Step("The user adds the comment to task")
    public TaskPage addTheCommentToTask(String addComment) {
        getAddCommentBtn().shouldBe(Condition.visible).click();
        getAddCommentField().shouldBe(Condition.visible).sendKeys(addComment);
        getSubmitCommentBtn().shouldBe(Condition.visible).click();
        return new TaskPage();

    }

    @Step("The user closes the task")
    public TaskPage closeTheTask() {
        getCloseTaskBtn().shouldBe(Condition.visible).click();
        getYesBtn().shouldBe(Condition.visible).click();
        return new TaskPage();
    }

    public SelenideElement getCloseTaskBtn() {
        return closeTaskBtn;
    }

    public SelenideElement getYesBtn() {
        return yesBtn;
    }

    public SelenideElement getStatusTask() {
        return statusTask;
    }

    public SelenideElement getAddCommentBtn() {
        return addCommentBTn;
    }

    public SelenideElement getAddCommentField() {
        return addCommentField;
    }

    public SelenideElement getSubmitCommentBtn() {
        return submitCommentBtn;
    }

    public SelenideElement getTheCommentName() {
        return theCommentName;
    }
}
