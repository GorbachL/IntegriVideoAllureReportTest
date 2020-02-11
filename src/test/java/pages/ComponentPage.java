package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.AllureUtils;

public class ComponentPage extends BasePage {

    @FindBy(xpath = "//select[@data-select2-id='1']")
    WebElement componentType;
    @FindBy(name = "name")
    WebElement componentName;

    private By CREATE_BUTTON = By.xpath("//button[text()='Create']");
    private By UPDATE_BUTTON = By.xpath("//button[text()='Update']");

    public ComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open component page")
    public ComponentPage openPage() {
        isPageOpened(CREATE_BUTTON);
        PageFactory.initElements(driver, ComponentPage.this);
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

    @Step("select component Type")
    public void selectComponentType() {
        Select select = new Select(componentType);
        select.getOptions().get(1).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("enter component Name")
    public void addNameOfComponent(String name) {
        componentName.sendKeys(name);
        AllureUtils.takeScreenshot(driver);
    }

    @Step("create Component")
    public void createComponent() {
        driver.findElement(CREATE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("update Component")
    public void updateComponent() {
        driver.findElement(UPDATE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }
}
