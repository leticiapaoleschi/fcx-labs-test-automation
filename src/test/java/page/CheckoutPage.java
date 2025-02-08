package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.UUID;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By tabletsButton = By.id("tabletsImg");
    private final By productImage = By.className("imgProduct");
    private final By addToCartButton = By.name("save_to_cart");
    private final By checkoutPopup = By.id("checkOutPopUp");
    private final By nextButton = By.id("next_btn");
    private final By safePayUsernameField = By.name("safepay_username");
    private final By safePayPasswordField = By.name("safepay_password");
    private final By payNowButton = By.id("pay_now_btn_SAFEPAY");
    private final By messagePaymentSuccess = By.id("orderPaymentSuccess");

    public void clickOnProduct() {
        click(tabletsButton);
    }

    public void clickOnTablet() {
        click(productImage);
    }

    public void clickOnAddToCart() {
        click(addToCartButton);
    }

    public void clickOnCheckoutPopup() {
        click(checkoutPopup);
    }

    public void clickOnNextButton() {
        click(nextButton);
    }

    public void enterSafePayUsername(String username) {
        String randomUsername = username + UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
        sendKeys(safePayUsernameField, randomUsername);
    }

    public void enterSafePayPassword(String password) {
        sendKeys(safePayPasswordField, password);
    }

    public void clickOnPayNowButton() {
        click(payNowButton);
    }

    public boolean getConfirmationMessage() {
        return isElementVisibleById(messagePaymentSuccess);
    }
}
