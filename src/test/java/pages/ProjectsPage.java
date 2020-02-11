package pages;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import java.util.List;

public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//a[text()='Billing']")
    WebElement billingButton;
    @FindBy(xpath = "//a[text()='Projects']")
    WebElement projectsButton;
    @FindBy(name = "name")
    WebElement projectNameInput;
    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    WebElement projectDescriptionInput;
    @FindBy(xpath = "//button[text()='Create']")
    WebElement projectCreateButton;
    @FindBy(xpath = "//button[text()='Update']")
    WebElement projectUpdateButton;

    private By ADD_PROJECT = By.xpath("//div[text()='Add project']");
    private By PROJECT_CREATE = By.xpath("//a[text()='Create']");
    private By PROJECT_DOMAIN_INPUT = By.name("domains[]");
    private By ACTIVE_PROJECTS = By.xpath("//div[@class='project']");
    private By EDIT_PROJECT = By.xpath("//a[text()='Edit']");
    private By REMOVE_DOMAIN = By.className("input-group-text");
    private By ADD_NEW_COMPONENT = By.xpath("//div[text()='Add new component']");

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open integrivideo project page")
    public ProjectsPage openPage() {
        driver.get("https://dev.integrivideo.com/app/projects");
        isPageOpened(ADD_PROJECT);
        PageFactory.initElements(driver, ProjectsPage.this);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    public void isPageOpened(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (TimeoutException ex) {
            throw new TimeoutException("Page is not opened");
        }
    }

    public void clickLogOut() {
        logoutButton.click();
    }

    public void clickBilling() {
        billingButton.click();
    }

    public void clickProject() {
        projectsButton.click();
    }

    @Step("click add Project")
    public void clickAddProject() {
        driver.findElement(ADD_PROJECT).click();
        isPageOpened(PROJECT_CREATE);
    }

    public int projectCount() {
        List<WebElement> projects = driver.findElements(ACTIVE_PROJECTS);
        return projects.size();
    }

    @Step("fill in data of a New Project")
    public void fillInNewProject(Project project) {
        projectNameInput.sendKeys(project.getProjectName());
        projectDescriptionInput.sendKeys(project.getProjectDescription());
        driver.findElement(PROJECT_DOMAIN_INPUT).sendKeys(project.getDomains());
        AllureUtils.takeScreenshot(driver);
    }

    public void createNewProject() {
        projectCreateButton.click();
    }

    @Step("update project")
    public void editProjectData(Project project) {
        projectNameInput.clear();
        projectNameInput.sendKeys(project.getProjectName());
        projectDescriptionInput.clear();
        projectDescriptionInput.sendKeys(project.getProjectDescription());
        driver.findElement(PROJECT_DOMAIN_INPUT).clear();
        driver.findElement(PROJECT_DOMAIN_INPUT).sendKeys(project.getDomains());
        AllureUtils.takeScreenshot(driver);
    }

    @Step("select project to update")
    public void selectProjectToUpdate() {
        List<WebElement> projects = driver.findElements(ACTIVE_PROJECTS);
        projects.get(1).click();
        isPageOpened(ADD_NEW_COMPONENT);
        AllureUtils.takeScreenshot(driver);
    }

    @Step("click on Edit button")
    public void clickEditProject() {
        driver.findElement(EDIT_PROJECT).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("click on Update Project")
    public void updateProject() {
        projectUpdateButton.click();
    }

    public void removeDomain() {
        List<WebElement> domainList = driver.findElements(REMOVE_DOMAIN);
        domainList.get(0).clear();
    }

    @Step("click on add component")
    public void clickAddNewComponent() {
        driver.findElement(ADD_NEW_COMPONENT).click();
        AllureUtils.takeScreenshot(driver);
    }
}
