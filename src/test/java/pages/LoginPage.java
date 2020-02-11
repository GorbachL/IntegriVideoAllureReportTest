package pages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "login-form")
    WebElement logInForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open integrivideo login page")
    public void openPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        PageFactory.initElements(driver, LoginPage.this);
        AllureUtils.takeScreenshot(driver);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
        } catch (TimeoutException ex) {
            System.out.println("Page is not opened");
            throw new TimeoutException("Page is not opened");
        }
    }

    @Step("Login User")
    public void login(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        AllureUtils.takeScreenshot(driver);
        logInForm.submit();
    }

    @Step("Home Page - projects")
    public void verifyHomePage(String url) {
        String URL = "https://dev.integrivideo.com/app/projects";
        wait.until(ExpectedConditions.titleIs("IntegriVideo - Video components for your website"));
        assertEquals(url, URL, "https://dev.integrivideo.com/app/projects");
        AllureUtils.takeScreenshot(driver);
    }
}
