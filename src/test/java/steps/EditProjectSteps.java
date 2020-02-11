package steps;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;


public class EditProjectSteps {

    private Project project = new Project("Project test EDIT", "description for the test EDIT", "asd.by");

    private ProjectsPage projectsPage;

    public EditProjectSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
    }

    @Step("edit project")
    public void editProject() {
        projectsPage
                .openPage()
                .selectProjectToUpdate();
        projectsPage.clickEditProject();
        projectsPage.editProjectData(project);
        projectsPage.updateProject();
    }
}
