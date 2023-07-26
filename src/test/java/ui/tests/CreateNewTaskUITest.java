package ui.tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.LogInPage;
import ui.pageobjects.BoardPage;
import static ui.tests.Enums.*;

public class CreateNewTaskUITest extends BaseUITest {
     @Test
    @Description("The test is checking positive test creating the new task")
    public void testCreateTaskPositive() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD)
                .newProjectButton()
                .setUpNewProject(PROJECT_NAME, TASK_LIMIT)
                .clickBoardTab()
                .pushTheNewTaskButton()
                .createNewTask(TITTLE, DESCRIPTION, PRIORITY);


        String actualTaskName = new BoardPage().getTheTaskName().getText();
        String expectedTaskName = "My new Task";

        Assert.assertEquals(actualTaskName, expectedTaskName, "You didn't create the task");
    }

}
