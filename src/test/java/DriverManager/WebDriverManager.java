package DriverManager;

import Configuration.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WebDriverManager {

   // private  WebDriver webDriver1;
    WebDriver webDriver1;
    private static ConfigFileReader fileReader;
    private static WebDriverManager instance; // to use the same instance of the class.


//    String ChromeDriverPath;
//    String FirefoxDriverPath;

    public void propertySetup() {
     String browserType =  fileReader.getBrowserType().toLowerCase();
          if (browserType == "chrome") {
              System.setProperty("webdriver.chrome.driver", fileReader.getChromeDriverPath());
              webDriver1 = new ChromeDriver();
              webDriver1.manage().deleteAllCookies();
          }
          else if (browserType == "firefox") {
              System.setProperty("webdriver.gecko.driver", fileReader.getFirefoxDriverPath());
              webDriver1 = new FirefoxDriver();
              webDriver1.manage().deleteAllCookies();
          }
          else if (browserType == "ie") {
              //   Need to be implemented
          }
          else{
                throw new RuntimeException("Unable to recognized browser.Type in Configuration.properties file.");
          }
    }

    public static WebDriverManager getInstance(){
        if(instance==null){
            instance =   new WebDriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return webDriver1;
    }


    public static String getUrl() {
         return (fileReader.getWebSiteUrl());
    }

}
