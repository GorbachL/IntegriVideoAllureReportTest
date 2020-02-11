package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.CreateNewProjectSteps;

public class CreateNewProjectTest extends BaseTest {

    private CreateNewProjectSteps stepsForProject;

    @Test(description = "Create a NEW project")
    @Description("Validate creating a new project")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void validateCreationOfNewProjectTest() {
        stepsForLogin.login();
        stepsForProject = new CreateNewProjectSteps(driver);
        stepsForProject.creationOfNewProject();
    }
}
