package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hooks {
    private static WebDriver driver;
    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());

    @Before
    public void setup() {
        if (driver == null) {
            String driverPath = Paths.get("src", "test", "resources", "chromedriver-win64", "chromedriver.exe")
                    .toAbsolutePath()
                    .toString();
            System.setProperty("webdriver.chrome.driver", driverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.advantageonlineshopping.com/");

            LOGGER.log(Level.INFO, "Browser started and navigated to the website.");
        }
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
            driver = null;
            LOGGER.log(Level.INFO, "Browser closed.");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
