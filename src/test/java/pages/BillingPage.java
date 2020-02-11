package pages;

import io.qameta.allure.Step;
import models.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class BillingPage extends BasePage {

    @FindBy(name = "number")
    WebElement cardNumberInput;
    @FindBy(name = "expirationMonth")
    WebElement cardMonthInput;
    @FindBy(name = "expirationYear")
    WebElement cardYearInput;
    @FindBy(name = "cardholderName")
    WebElement cardHolderInput;

    private By ADD_NEW_BUTTON = By.xpath("//a[text()='Add new']");
    private By ADD_BUTTON = By.xpath("//button[text()='Add']");
    private By REMOVE_BUTTON = By.xpath("//a[text()='Remove']");

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    @Step("open billing page")
    public BillingPage openPage() {
        isPageOpened(ADD_NEW_BUTTON);
        PageFactory.initElements(driver, BillingPage.this);
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

    @Step("click on Add new button")
    public BillingPage clickAddNewButton() {
        driver.findElement(ADD_NEW_BUTTON).click();
        isPageOpened(ADD_BUTTON);
        wait.until(ExpectedConditions.elementToBeClickable(ADD_BUTTON));
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("fill in card data")
    public BillingPage fillInDataForCard(Card card) {
        cardNumberInput.sendKeys(card.getCardNumber());
        cardMonthInput.sendKeys(card.getCardMonth());
        cardYearInput.sendKeys(card.getCardYear());
        cardHolderInput.sendKeys(card.getCardHolder());
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("save card")
    public BillingPage clickAddPaimentDetails() {
        driver.findElement(ADD_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("remove card")
    public BillingPage removeCard() {
        driver.findElement(REMOVE_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

}
