package amazontest;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class AmazonPageTest extends BaseTest{

    public static void searchItem(final WebDriver driver, final String item) {
        final WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(item);
        searchBox.sendKeys(Keys.ENTER);
        waitForPageToLoad(driver);
    }
}
