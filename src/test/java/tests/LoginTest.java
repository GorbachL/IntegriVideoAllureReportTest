package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class LoginTest extends BaseTest {

    private LoginSteps steps;

    @Test(description = "Log in Integrivideo")
    @Description("Validate login")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void logInTest() {
        steps = new LoginSteps(driver);
        steps.login();
    }
}
