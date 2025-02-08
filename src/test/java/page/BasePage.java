package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findElement(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Element not found: " + locator, e);
            return null;
        }
    }

    public void sendKeys(By locator, String text) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while sending keys to element: " + locator, e);
        }
    }

    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error clicking element: " + locator, e);
        }
    }

    public void sendKeysWithEnter(By locator, String value) {
        try {
            WebElement element = findElement(locator);
            if (element != null) {
                element.sendKeys(value);
                element.sendKeys(Keys.ENTER);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error sending keys with Enter to element: " + locator, e);
        }
    }

    public boolean isElementVisibleById(By elementId) {
        try {
            WebElement element = driver.findElement(elementId);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
