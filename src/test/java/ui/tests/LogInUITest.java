package ui.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pageobjects.LogInPage;

import static ui.tests.Enums.*;

public class LogInUITest extends BaseUITest {
    @Test
    @Description("The test is checking positive test for login")
    public void testLogInPositive() {
        new LogInPage()
                .logIn(USERNAME, PASSWORD);

        Assert.assertEquals(WebDriverRunner.getWebDriver().getTitle(), "Dashboard for " + USERNAME
                , "The login was not successful");

    }

    @Test
    @Description("The test is checking negative scenario for login with empty password")
    public void testLogInNegative() {
        new LogInPage()
                .logIn(USERNAME, PASS_EMPTY);

        Assert.assertEquals(WebDriverRunner.getWebDriver().getTitle(), "Dashboard for " + USERNAME
                , "The login was not successful");

    }

    @Test
    @Description("The test is checking the second negative scenario for " +
            "login with unregistered name and password")
    public void testLogInNegative2() {
        new LogInPage()
                .logIn(NAME_WRONG, PASS_WRONG);

        Assert.assertEquals(WebDriverRunner.getWebDriver().getTitle(), "Dashboard for " + USERNAME
                , "The login was not successful");

    }
}