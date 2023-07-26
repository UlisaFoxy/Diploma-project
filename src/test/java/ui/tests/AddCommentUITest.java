package ui.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.LogInPage;
import ui.pageobjects.TaskPage;

import static ui.tests.Enums.*;

public class AddCommentUITest extends BaseUITest {
    @Test
    @Description("The test is checking positive test adding the comment to the task")
    public void testAddComment() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD)
                .newProjectButton()
                .setUpNewProject(PROJECT_NAME, TASK_LIMIT)
                .clickBoardTab()
                .pushTheNewTaskButton()
                .createNewTask(TITTLE, DESCRIPTION, PRIORITY)
                .goToTaskPage()
                .addTheCommentToTask(COMMENT);


        String actualComment = new TaskPage().getTheCommentName().getText();
        String expectedComment = "My first comment";

        Assert.assertEquals(actualComment, expectedComment, "You didn't add the comment to the task");
    }

}
