package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.SendMessageViaButtonSteps;

public class SendMessageViaButtonTest extends BaseTest{

    SendMessageViaButtonSteps steps;

    @Test(description = "Send message via button")
    @Description("Validate sending message via button")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void validateMessageSendingTest() {
        String message = "Отправить любое сообщение используя Кнопку";

        steps = new SendMessageViaButtonSteps(driver);
        steps.validateMessageSending(message);
    }
}
