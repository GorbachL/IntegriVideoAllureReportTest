package steps;

import io.qameta.allure.Step;
import models.Card;
import org.openqa.selenium.WebDriver;
import pages.BillingPage;
import pages.ProjectsPage;

public class AddNewCardSteps {

    private Card card = new Card("4242424242424242", "12", "2022", "Card User");

    private ProjectsPage projectsPage;
    private BillingPage billingPage;

    public AddNewCardSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        billingPage = new BillingPage(driver);
    }

    @Step("add Card")
    public void addCard() {
        projectsPage
                .openPage()
                .clickBilling();
        billingPage
                .openPage()
                .clickAddNewButton();
        billingPage.fillInDataForCard(card);
        billingPage.clickAddPaimentDetails();
    }

}
