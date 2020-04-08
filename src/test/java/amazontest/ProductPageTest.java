package amazontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProductPageTest extends BaseTest {

    public static void verifyProductTopicContainsText(final WebDriver driver, final String expectedTextInTopic) {
        final String valueToVerify = driver.findElement(By.id("productTitle")).getText();
        assertTrue(String.format("Expected to product topic contain text '%s'!", expectedTextInTopic),
                valueToVerify.contains(expectedTextInTopic));
    }
}
