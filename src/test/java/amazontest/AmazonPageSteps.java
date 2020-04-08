package amazontest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static amazontest.ResultPageTest.SortResults.PRICEHIGHTOLOW;

public class AmazonPageSteps {
    private WebDriver driver;
    public static final String URL = "http://www.amazon.com";
    private static final String expectedValue = "Nikon D3X";

    final AmazonPageTest amazonPage = new AmazonPageTest();
    final ResultPageTest resultPage = new ResultPageTest();
    final ProductPageTest productPage = new ProductPageTest();

    @Before
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("Open Chrome and navigate to 'amazon.com'")
    public void open_Chrome_and_navigate_to_amazon_com() {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
    }

    @When("Search Nikon and sort results from highest price to slowest")
    public void search_Nikon_and_sort_results_from_highest_price_to_slowest() {
        amazonPage.searchItem(driver, "Nikon");
        resultPage.sortResults(driver, PRICEHIGHTOLOW);
    }

    @And("Select second product and click it for details")
    public void select_second_product_and_click_it_for_details() {
        resultPage.selectAndClickItemInResults(driver, 1);
    }

    @Then("From details verify that product topic contains text 'Nikon D3X'")
    public void from_details_verify_that_product_topic_contains_text_Nikon_D3X() {
        productPage.verifyProductTopicContainsText(driver, expectedValue);
    }

}
