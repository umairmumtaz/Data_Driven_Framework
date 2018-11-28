package Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class demoqa {

    WebDriver WebDriver1;
    WebElement WebElement1;

    @BeforeSuite
    void Property_Setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Intallations/chromedriver.exe");
    }

    @BeforeTest
    void Browser_Setup() {
        WebDriver1 = new ChromeDriver();
        System.out.println("Testing Begins"); //cookies clear
        WebDriver1.get("http://store.demoqa.com");
    }

//    @BeforeClass
//    void Url_Setup() {
//
//    }


    @Test(testName ="E2E")
    void HomePage() throws Exception {
        WebElement ProductCategory = WebDriver1.findElement(By.xpath(("//*[@id=\"menu-item-33\"]/a")));
        ProductCategory.click();
    }

    @Test(dependsOnMethods = "HomePage",testName ="E2E")
    void AccessoriesPage(){
        WebElement Accessories = WebDriver1.findElement(By.xpath(("//*[@id=\"menu-item-34\"]")));



        // Accessories.click();
        WebElement MagicMouse_AddToCart_Btn = WebDriver1.findElement(By.xpath(("//*[@id=\"default_products_page_container\"]//input[@type = \"submit\" and @value=\"Add To Cart\" and @name=\"Buy\" and @class=\"wpsc_buy_button\"]")));

        MagicMouse_AddToCart_Btn.click();

        WebElement Checkout = WebDriver1.findElement(By.xpath(("//*[@id=\"header_cart\"]/a")));
        Checkout.click();


        //Need to add a check
//        WebElement Input_Quantity = WebDriver1.findElement(By.xpath(("")));
//       String x = Input_Quantity.getText();


        WebElement Continue_Btn = WebDriver1.findElement(By.xpath(("//*[@id=\"checkout_page_container\"]/div[1]/a/span")));
        Continue_Btn.click();
    }

    @Test(dependsOnMethods = "AccessoriesPage",testName ="E2E")
    void BillingDetails_Form(){


        WebElement Input_Email = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_9\"]")));
        System.out.println("aded");
        WebElement Input_FirstName = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_2\"]")));

        WebElement Input_LastName = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_3\"]")));

        WebElement Input_Address = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_4\"]")));

        WebElement Input_City = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_5\"]")));

        WebElement Input_Undefined = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_6\"]")));
        WebElement Input_Country = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_7\"]/option[41]")));
        WebElement Input_PostalCode = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_8\"]")));
        WebElement Input_Phone = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_18\"]")));

        WebElement SameAsBillingAddress_CheckBox = WebDriver1.findElement(By.xpath(("//*[@id=\"shippingSameBilling\"]")));
        WebElement Purchase_Btn = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_shopping_cart_container\"]/form/div[4]/div/div/span/input")));

    }







}
