package amazontest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPageTest extends BaseTest{

    public static void sortResults(final WebDriver driver, final SortResults sortresults) {
        driver.findElement(By.id("a-autoid-0")).click();
        driver.findElement(By.id(sortresults.getElementId())).click();
        waitForPageToLoad(driver);
    }

    public static void selectAndClickItemInResults(final WebDriver driver, final int index) {
        driver.findElements(By.cssSelector("[cel_widget_id='SEARCH_RESULTS-SEARCH_RESULTS']")).get(index)
                .findElement(By.className("sg-col-inner")).click();
        waitForPageToLoad(driver);
    }

    enum SortResults {
        FEATURED("0"),
        PRICELOWTOHIGH("1"),
        PRICEHIGHTOLOW("2"),
        AVGCUSTOMERREVIEW("3"),
        NEWESTARRIVALS("4");

        private final String id;
        private final String sortElementIdPrefix = "s-result-sort-select_";

        SortResults(final String id) { this.id = id; }

        public String getElementId() { return String.format("%s%s", sortElementIdPrefix, id); }
    }
}
