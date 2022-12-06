package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy (xpath = "//a[@href = '/basta.html']")
    WebElement bastaISlobodnoVremeMenuOption;

    @FindBy (xpath = "//a[@href = 'https://www.emmezeta.rs/basta/rostilji-i-oprema.html']")
    WebElement rostiljIOpremaSubMenuOption;

//    @FindBy (xpath = "//a[@href = 'https://www.emmezeta.rs/kuvanje/svet-rostilja/rostilji.html']")
    @FindBy (xpath = "//a[@href = 'https://www.emmezeta.rs/basta/rostilji-i-oprema.html']//..//span[text() = 'Roštilji']")
    WebElement rostiljiSubSubMenuOption;

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get("https://www.emmezeta.rs/");
        print("HOme page");
        this.clickAcceptInCookie();
    }




    public void hoverBastaISlobodnoVremeMenu() {
        hoverOverElement(bastaISlobodnoVremeMenuOption);
    }

    public void chooseRostiljFromSubMenu() {
        hoverOverElement(bastaISlobodnoVremeMenuOption);
        hoverOverElement(rostiljIOpremaSubMenuOption);
        hoverOverElement(rostiljiSubSubMenuOption);
        rostiljiSubSubMenuOption.click();
    }

}
