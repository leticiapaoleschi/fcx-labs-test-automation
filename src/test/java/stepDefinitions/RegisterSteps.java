package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.RegisterPage;
import stepDefinitions.Hooks;

import java.time.Duration;

public class RegisterSteps {
    private final RegisterPage registerPage;
    private final WebDriverWait wait;

    public RegisterSteps() {
        WebDriver driver = Hooks.getDriver();
        registerPage = new RegisterPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("The user completes the registration form with {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
    public void theUserFillsTheRegistrationForm(
            String username, String email, String password, String firstName, String lastName,
            String phoneNumber, String country, String city, String address, String state, String postalCode) {

        registerPage.waitForSeconds(5);
        registerPage.clickOnUserMenu();
        registerPage.waitForSeconds(1);
        registerPage.clickOnCreateAccount();
        registerPage.waitForSeconds(1);

        registerPage.enterUsername(username);
        registerPage.enterEmail(email);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(password);
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.enterPhoneNumber(phoneNumber);

        registerPage.waitForSeconds(2);
        registerPage.enterCountry(country);

        registerPage.enterCity(city);
        registerPage.enterAddress(address);
        registerPage.enterState(state);
        registerPage.enterPostalCode(postalCode);
    }

    @Given("Agrees to the terms and submits the registration")
    public void agreesToTheTermsAndSubmits() {
        registerPage.waitForSeconds(2);
        registerPage.clickOnAgreeCheckbox();
        registerPage.clickOnRegister();
    }
}
