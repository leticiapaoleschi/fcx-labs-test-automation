package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.CheckoutPage;

import java.time.Duration;

public class CheckoutSteps {
    private final CheckoutPage checkoutPage;
    private final WebDriverWait wait;

    public CheckoutSteps() {
        WebDriver driver = Hooks.getDriver();
        checkoutPage = new CheckoutPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @And("The user adds items to the cart")
    public void theUserAddsItemsToTheCart() {
        checkoutPage.waitForSeconds(2);
        checkoutPage.clickOnProduct();
        checkoutPage.waitForSeconds(2);
        checkoutPage.clickOnTablet();
        checkoutPage.waitForSeconds(2);
        checkoutPage.clickOnAddToCart();
    }

    @And("The user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        checkoutPage.clickOnCheckoutPopup();
        checkoutPage.waitForSeconds(2);
        checkoutPage.clickOnNextButton();
    }

    @When("The user enters SafePay credentials {string} and {string}")
    public void theUserFillsSafePayCredentials(String username, String password) {
        checkoutPage.waitForSeconds(2);
        checkoutPage.enterSafePayUsername(username);
        checkoutPage.enterSafePayPassword(password);
        checkoutPage.clickOnPayNowButton();
        checkoutPage.waitForSeconds(1);
    }

    @Then("The checkout process should be successful")
    public void theUserCompletesThePurchase() {
        boolean isSuccessMessageVisible = checkoutPage.getConfirmationMessage();
        Assert.assertTrue("Error: Checkout success message was not displayed!", isSuccessMessageVisible);
        checkoutPage.waitForSeconds(3);
    }
}
