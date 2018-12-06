package Configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


//Thos clas reads Properties File & Pass information to Driver Manger Class.
public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath= "C:\\Users\\umair\\IdeaProjects\\Automation_Challenge1\\src\\test\\resources\\Configuration.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }

    public String getBrowserType() {
        String browserType = properties.getProperty("browser.Type");
        if(browserType != null)
            return (browserType);
        else throw new RuntimeException("browser.Type not specified in the Configuration.properties file.");
    }

    public String getChromeDriverPath() {
        String  chromeDriverPath = properties.getProperty("chrome.driver.path");
        if(chromeDriverPath != null)
            return (chromeDriverPath);
        else throw new RuntimeException("chrome.driver.path not specified in the Configuration.properties file.");
    }

    public String getFirefoxDriverPath() {
        String  firefoxDriverPath = properties.getProperty("firefox.driver.path");
        if(firefoxDriverPath != null)
            return (firefoxDriverPath);
        else throw new RuntimeException("firefox.driver.path not specified in the Configuration.properties file.");
    }


    public String getWebSiteUrl() {
        String url = properties.getProperty("website.url");
        if(url != null)
            return url;
        else throw new RuntimeException("website.url not specified in the Configuration.properties file.");
    }

}



