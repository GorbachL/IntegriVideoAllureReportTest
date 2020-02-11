package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.AddNewComponentSteps;

public class AddNewComponentTest extends BaseTest {

    private AddNewComponentSteps stepsForAddComponent;

    @Test(description = "Add New Component")
    @Description("Validate new Component can be added to the project")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void validateAddingNewComponent() {
        stepsForLogin.login();
        stepsForAddComponent = new AddNewComponentSteps(driver);
        stepsForAddComponent.addNewComponent("component L");
    }
}
