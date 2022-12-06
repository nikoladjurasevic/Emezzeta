package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(ChromeDriver driver) {
        super(driver);
        print("Search result page");
    }

    public void clickOnItemInList(String itemName) {
        List<WebElement> items = driver.findElements(By.xpath("//li[@class = 'item product product-item']"));
        for(WebElement item : items) {
            String curentItemName = item.findElement(By.xpath(".//a[@class = 'product-item-link']")).getText();
            if (curentItemName.contains(itemName)) {
                scrollToElement(item);
                item.click();
                break;
            }
        }
    }


}
