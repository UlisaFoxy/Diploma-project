package ui.tests;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.LogInPage;
import ui.pageobjects.TaskPage;

import static ui.tests.Enums.*;
public class CloseTaskUITest extends BaseUITest {
    @Test
    @Description("The test is checking positive test to close the task")
    public void testCloseTask() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD)
                .newProjectButton()
                .setUpNewProject(PROJECT_NAME, TASK_LIMIT)
                .clickBoardTab()
                .pushTheNewTaskButton()
                .createNewTask(TITTLE, DESCRIPTION, PRIORITY)
                .goToTaskPage()
                .addTheCommentToTask(COMMENT)
                .closeTheTask();


        String actualStatus = new TaskPage().getStatusTask().getText();
        String expectedStatus = " closed ";

        Assert.assertEquals(actualStatus.trim(), expectedStatus, "The task status is not as expected.");

    }

}
