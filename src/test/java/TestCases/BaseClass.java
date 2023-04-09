package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BaseClass {

    // this is a duplicate method, as to just quickly check whether browser is getting open or not.
    @Test
     public void test1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\umumtaz\\AquaProjects\\Data_Driven_Framework\\src\\test\\Resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://www.wikipedia.org/";
        driver.get(baseUrl);
    }

}
