package steps;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

import static org.testng.Assert.assertEquals;

public class CreateNewProjectSteps {

    private Project project = new Project("Project test", "description for the test", "qwe.by");

    private ProjectsPage projectsPage;

    public CreateNewProjectSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
    }

    @Step("create a new project")
    public void creationOfNewProject() {
        projectsPage.openPage();
        int projectCountBefore = projectsPage.projectCount();
        projectsPage
                .clickAddProject()
                .fillInNewProject(project)
                .createNewProject()
                .openPage();
        int projectCountAfter = projectsPage.projectCount();
        assertEquals(projectCountAfter, projectCountBefore + 1, "New project was not created");
    }
}
