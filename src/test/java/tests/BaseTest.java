package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;

public class BaseTest {


    //Ovde pravimo metodu koja otvara chrome sa svim potrebnim opcijama
    public ChromeDriver openChromeDriver() {
        print("Openening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--start-maximized"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        //ovo dole sluzi za setovanje dimenzija browsera
//        driver.manage().window().setSize(new Dimension(600,768));
        return driver;
    }

    //ovo sluzi samo za printanje texta u konzoli
    public static void print(String s) {
        BasePage.print(s);
    }

}
