package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.UUID;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.name("emailRegisterPage");
    private final By passwordField = By.name("passwordRegisterPage");
    private final By confirmPasswordField = By.name("confirm_passwordRegisterPage");
    private final By addressField = By.name("addressRegisterPage");
    private final By phoneNumberField = By.name("phone_numberRegisterPage");
    private final By firstNameField = By.name("first_nameRegisterPage");
    private final By usernameField = By.name("usernameRegisterPage");
    private final By lastNameField = By.name("last_nameRegisterPage");
    private final By registerButton = By.id("register_btn");
    private final By countryDropdown = By.name("countryListboxRegisterPage");
    private final By cityField = By.name("cityRegisterPage");
    private final By stateField = By.name("state_/_province_/_regionRegisterPage");
    private final By postalCodeField = By.name("postal_codeRegisterPage");
    private final By agreeCheckbox = By.name("i_agree");
    private final By createAccountButton = By.className("create-new-account");
    private final By userMenuButton = By.id("menuUserLink");

    public void clickOnUserMenu() {
        click(userMenuButton);
    }

    public void clickOnCreateAccount() {
        click(createAccountButton);
    }

    public void enterUsername(String usernameValue) {
        String randomUsername = usernameValue + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
        sendKeys(usernameField, randomUsername);
    }

    public void enterEmail(String emailValue) {
        String[] emailParts = emailValue.split("@", 2);
        if (emailParts.length == 2) {
            String randomEmail = emailParts[0] + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8) + "@" + emailParts[1];
            sendKeys(emailField, randomEmail);
        } else {
            throw new IllegalArgumentException("Invalid email format: " + emailValue);
        }
    }

    public void enterPassword(String passwordValue) {
        sendKeys(passwordField, passwordValue);
    }

    public void enterConfirmPassword(String confirmPasswordValue) {
        sendKeys(confirmPasswordField, confirmPasswordValue);
    }

    public void enterFirstName(String firstNameValue) {
        sendKeys(firstNameField, firstNameValue);
    }

    public void enterLastName(String lastNameValue) {
        sendKeys(lastNameField, lastNameValue);
    }

    public void enterPhoneNumber(String phoneNumberValue) {
        if (phoneNumberValue.length() == 10) {
            sendKeys(phoneNumberField, phoneNumberValue);
        } else {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
    }

    public void enterCountry(String countryValue) {
        sendKeysWithEnter(countryDropdown, countryValue);
    }

    public void enterCity(String cityValue) {
        sendKeys(cityField, cityValue);
    }

    public void enterAddress(String addressValue) {
        sendKeys(addressField, addressValue);
    }

    public void enterState(String stateValue) {
        sendKeys(stateField, stateValue);
    }

    public void enterPostalCode(String postalCodeValue) {
        sendKeys(postalCodeField, postalCodeValue);
    }

    public void clickOnAgreeCheckbox() {
        click(agreeCheckbox);
    }

    public void clickOnRegister() {
        click(registerButton);
    }
}
