package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class EnvSetUp {

 public static WebDriver webDriver1;

    @BeforeSuite
    @Parameters("pChromeDriverPath")
    void propertySetup(String pChromeDriverPath) {
        System.setProperty("webdriver.chrome.driver",pChromeDriverPath);
    }

    @BeforeTest
    @Parameters("pURL")
    void browserSetup() {
        webDriver1 = new ChromeDriver();
        webDriver1.manage().deleteAllCookies(); //delete all cookies
    }


}
