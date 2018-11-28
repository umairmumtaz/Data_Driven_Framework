package Execution;

import javafx.scene.text.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
    void HomePageTC1
            () throws Exception {
        WebElement ProductCategory = WebDriver1.findElement(By.xpath(("//*[@id=\"menu-item-33\"]/a")));
        ProductCategory.click();
    }

    @Test(dependsOnMethods = "HomePageTC1",testName ="E2E")
    void AccessoriesPageTC1(){

        //Accessories Drop Down
        WebElement Accessories = WebDriver1.findElement(By.xpath(("//*[@id=\"menu-item-34\"]")));

        //Magic Mouse Add to Cart Button
        WebElement MagicMouse_AddToCart_Btn = WebDriver1.findElement(By.xpath(("//*[@id=\"default_products_page_container\"]//input[@type = \"submit\" and @value=\"Add To Cart\" and @name=\"Buy\" and @class=\"wpsc_buy_button\"]")));
        MagicMouse_AddToCart_Btn.click();

        //wait until item is added into the cart.
        WebDriverWait wait=new WebDriverWait(WebDriver1, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"default_products_page_container\"]/div[3]/div[2]/form/div[2]/div[1]/div[2]/p[text()]")));

        //Verify Alert Message
        WebElement AlertMessage = WebDriver1.findElement(By.xpath(("//*[@id=\"default_products_page_container\"]/div[3]/div[2]/form/div[2]/div[1]/div[2]/p[text()]")));
        String ExpectedMessage = "Item has been added to your cart!";
        String Message1= AlertMessage.getText();
        String Message2= AlertMessage.getTagName();
        boolean x = AlertMessage.isSelected();
        Boolean y = AlertMessage.isEnabled();
        Assert.assertEquals(false, AlertMessage.isDisplayed());
        //CheckOut Button
        WebElement Checkout = WebDriver1.findElement(By.xpath(("//*[@id=\"header_cart\"]/a")));
        Checkout.click();
    }

    @Test(dependsOnMethods = "AccessoriesPageTC1",testName ="E2E")
    void checkoutPageTC1(){

        //   confirming Checkout quantity =1
        WebElement Input_Quantity = WebDriver1.findElement(By.xpath(("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")));
        Assert.assertEquals(Input_Quantity.getAttribute("value"), "1");

        //Continue Button
        WebElement Continue_Btn = WebDriver1.findElement(By.xpath(("//*[@id=\"checkout_page_container\"]/div[1]/a/span")));
        Continue_Btn.click();
    }

    @Test(dependsOnMethods = "checkoutPageTC1",testName ="E2E")
    //Billing details form
    void checkoutPageTC2(){

        WebElement InputEmail = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_9\"]")));
        System.out.println("aded");
        WebElement InputFirstName = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_2\"]")));

        WebElement InputLastName = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_3\"]")));

        WebElement InputAddress = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_4\"]")));

        WebElement InputCity = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_5\"]")));

        WebElement InputUndefined = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_6\"]")));
        WebElement InputCountry = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_7\"]/option[41]")));
        WebElement InputPostalCode = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_8\"]")));
        WebElement InputPhone = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_18\"]")));

        WebElement SameAsBillingAddressCheckBox = WebDriver1.findElement(By.xpath(("//*[@id=\"shippingSameBilling\"]")));
        WebElement PurchaseBtn = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_shopping_cart_container\"]/form/div[4]/div/div/span/input")));

    }

    @Test(dependsOnMethods = "checkoutPageTC2",testName ="E2E")
    void TransactionResultsPageTC1(){

    //need to c=verify purchase.
//        try
//        {
//
//        }
//        catch (Exception)
//        {
//            return null;
//        }

    }







}
