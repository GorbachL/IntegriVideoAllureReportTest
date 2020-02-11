package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ComponentPage;
import pages.ProjectsPage;

public class AddNewComponentSteps {

    private ProjectsPage projectsPage;
    private ComponentPage componentPage;

    public AddNewComponentSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        componentPage = new ComponentPage(driver);
    }

    @Step("add component")
    public void addNewComponent(String nameOfComponent) {
        projectsPage
                .openPage()
                .selectProjectToUpdate()
                .clickAddNewComponent();
        componentPage
                .openPage()
                .selectComponentType()
                .addNameOfComponent(nameOfComponent)
                .createComponent();
    }
}
