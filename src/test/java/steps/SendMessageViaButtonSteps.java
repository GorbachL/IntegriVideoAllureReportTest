package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IntegriChartPage;

public class SendMessageViaButtonSteps {

    private IntegriChartPage chartPage;

    public SendMessageViaButtonSteps(WebDriver driver) {

        chartPage = new IntegriChartPage(driver);
    }

    @Step("Send {message}")
    public SendMessageViaButtonSteps validateMessageSending(String message) {
        chartPage.openPage();
        chartPage.sendMessage(message);
        chartPage.clickSendMessageButton();
        chartPage.messageShouldContainText(message, 1);
        return this;
    }
}
