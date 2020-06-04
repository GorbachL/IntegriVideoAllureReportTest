package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.EditProjectSteps;

public class EditProjectTest extends BaseTest {

    private EditProjectSteps stepsForUpdateProject;

    @Test(description = "Edit project")
    @Description("Validate that project can be updated")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void validateProjectEditingTest() {
        stepsForLogin.login();
        stepsForUpdateProject = new EditProjectSteps(driver);
        stepsForUpdateProject.editProject();
    }
}
