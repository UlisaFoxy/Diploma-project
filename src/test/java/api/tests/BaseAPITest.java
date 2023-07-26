package api.tests;

import api.steps.UserAPISteps;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseAPITest {
    private static final String USERNAME = "user8899";
    private static final String PASSWORD = "myTestPassword";
    UserAPISteps userApiSteps = new UserAPISteps();
    private String userId;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Selenide.open("http://localhost/login/");
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        System.out.println(userId);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        userApiSteps.deleteUser(userId);
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }
}
