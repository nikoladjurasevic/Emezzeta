package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchResultPage;

public class SearchTests extends BaseTest {

    @Test
    public void searchSporetTest() {
        ChromeDriver driver = new ChromeDriver();
        String itemName = "Gorenje EC 5355 XPA";
        try {
            HomePage homePage = new HomePage(driver);
            homePage.searchForItem("sporet");
            SearchResultPage searchResultPage = new SearchResultPage(driver);
            searchResultPage.clickOnItemInList(itemName);

            ItemPage itemPage = new ItemPage(driver);
            String acctualItemName = itemPage.getItemName();
            assert acctualItemName.contains(itemName) : "Error. Wrong item name. Expected: " + itemName + " . Actual: " + acctualItemName;


        }finally {
//            driver.quit();
        }
    }

}
