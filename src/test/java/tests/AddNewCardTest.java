package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import steps.AddNewCardSteps;

public class AddNewCardTest extends BaseTest {

    private AddNewCardSteps stepsForNewCard;

    @Test(description = "Add Payment  Card")
    @Description("Validate new Card was added")
    @Link("Link for somewhere")
    @Issue("Link for issue")
    @TmsLink("Link for TMS")
    public void validateAddingPaymentCard() {
        stepsForLogin.login();
        stepsForNewCard = new AddNewCardSteps(driver);
        stepsForNewCard.addCard();
    }
}
