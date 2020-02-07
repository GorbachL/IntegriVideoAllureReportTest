package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IntegriChartPage;

public class SendMessageViaButtonSteps {

    private IntegriChartPage page;

    public SendMessageViaButtonSteps(WebDriver driver) {
        page = new IntegriChartPage(driver);
    }

    @Step("Send {message} via button")
    public SendMessageViaButtonSteps validateMessageSending(String message) {
        page.openPage();
        page.sendMessage(message);
        page.clickSendMessageButton();
        page.messageShouldContainText(message, 1);
        return this;
    }
}
