package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    ChromeDriver driver = null;

    @FindBy (xpath = "//input[@id = 'search']")
    WebElement searchField;

    @FindBy (xpath =  "//button[@title = 'Pretražite']")
    WebElement searchButton;

    @FindBy (xpath = "//div[@class = 'authorization-link-div']")
    WebElement myAccountButton;

    @FindBy (xpath = "//a[@id = 'CybotCookiebotDialogBodyButtonAccept']")
    WebElement cookieAcceptButton;

    public BasePage(ChromeDriver driver) {
        PageFactory.initElements(driver, this);
        print("Base Page");
        this.driver = driver;
    }


    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));    }

    public void clickAcceptInCookie() {
        waitForElement(cookieAcceptButton);
        cookieAcceptButton.click();
    }

    public void enterTextIntoSearchField(String text) {
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public void searchForItem(String text) {
        enterTextIntoSearchField(text);
        clickSearchButton();
    }

    public void hoverOverElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].mouseOver()", element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);" ,element);
    }

    //ovo sluzi samo za printanje texta u konzoli
    public static void print(String s) {
        System.out.println(s);
    }

}
