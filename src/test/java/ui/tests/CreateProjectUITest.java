package ui.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.BoardPage;
import ui.pageobjects.LogInPage;

import static ui.tests.Enums.*;

public class CreateProjectUITest extends BaseUITest {

    @Test
    @Description("The test is checking positive test creating the new project")
    public void testCreateProjectPositive() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD)
                .newProjectButton()
                .setUpNewProject(PROJECT_NAME, TASK_LIMIT)
                .getDescription();

        String actualDescription = new BoardPage().getDescription().getText();
        String expectedDescription = "This project is open";

        Assert.assertEquals(actualDescription, expectedDescription, "You didn't create the project");

    }
}
