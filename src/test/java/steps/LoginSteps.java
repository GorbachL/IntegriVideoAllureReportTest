package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("log in integrivideo")
    public LoginSteps login() {
        User user = new User("lenag@mailinator.com", "qwerty12345");
        String URL = "https://dev.integrivideo.com/app/projects";
        loginPage.openPage();
        loginPage.login(user);
        loginPage.verifyHomePage(URL);
        return this;
    }
}
