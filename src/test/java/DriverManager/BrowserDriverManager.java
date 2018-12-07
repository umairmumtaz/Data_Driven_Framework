package DriverManager;

import Configuration.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverManager {

    private WebDriver webDriver2;
    private static BrowserDriverManager instance;/// getting sam einstance of the Class Driver.
    String browserType = ConfigFileReader.getPropertyValue("browser.Type");

    private BrowserDriverManager() {
       try {
           if (browserType.equalsIgnoreCase("chrome")) {
               System.setProperty("webdriver.chrome.driver", ConfigFileReader.getPropertyValue("chrome.Driver.Path"));
               webDriver2 = new ChromeDriver();
           } else if (browserType.equalsIgnoreCase("firefox")) {
               System.setProperty("webdriver.gecko.driver", ConfigFileReader.getPropertyValue("firefox.Driver.Path"));
               webDriver2 = new FirefoxDriver();
           } else if (browserType.equalsIgnoreCase("ie")) {
               System.setProperty("webdriver.chrome.driver", ""); ///Need to be implemented
               webDriver2 = new ChromeDriver();
           }
           else System.out.println("browserType is not Properly defined in Configuration.properties file");
       }
        catch (Exception ex){
           ex.printStackTrace();
           System.out.println("Configuration.properties file either not Setup or Not written properly ");
            }
        }

        public static BrowserDriverManager getInstance ()
        {
            if (instance == null)
                instance = new BrowserDriverManager();
            return instance;
        }

        public WebDriver getWebDriver ()
        {
            return (webDriver2);
        }


    }
