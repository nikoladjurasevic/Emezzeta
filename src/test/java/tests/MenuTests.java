package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;

public class MenuTests extends BaseTest {


    @Test
    public void chooseRostiljFromMainHeaderMenuTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            HomePage homePage = new HomePage(driver);
//            homePage.hoverBastaISlobodnoVremeMenu();
            homePage.chooseRostiljFromSubMenu();

            String currentUrl = driver.getCurrentUrl();
            assert currentUrl.equals("https://www.emmezeta.rs/kuvanje/svet-rostilja/rostilji.html")  : "Wrong url. Actual " + currentUrl;

        }finally {
            driver.quit();
        }
    }

}
