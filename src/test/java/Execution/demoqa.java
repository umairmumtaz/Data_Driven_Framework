package Execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class demoqa {

    WebDriver WebDriver1;
    WebElement WebElement1;

    @BeforeSuite
    //@Parameters("pChromeDriverLocation")
    void Property_Setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Intallations/chromedriver.exe");
    }

    @BeforeTest
    @Parameters("pURL")
    void Browser_Setup(String pURL) {
        WebDriver1 = new ChromeDriver();
        WebDriver1.manage().deleteAllCookies(); //delete all cookies
        //Thread.Sleep(5000);
        WebDriver1.get(pURL);
    }

//    @BeforeClass : can be added if needed

    @Test(testName ="E2E")
    void HomePageTC1(){
        WebElement ProductCategory = WebDriver1.findElement(By.xpath(("//*[@id=\"menu-item-33\"]/a")));
        WebElement Accesssories = WebDriver1.findElement(By.xpath(("//*[@id=\"menu-item-34\"]/a")));

        Actions HoverClick = new Actions(WebDriver1);
        HoverClick.moveToElement(ProductCategory).click(Accesssories).build().perform();
    }

    @Test(dependsOnMethods = "HomePageTC1",testName ="E2E")
    @Parameters("pExpectedMessage")
    void AccessoriesPageTC1(String pExpectedMessage){
        //Magic Mouse Add to Cart Button
        WebElement MagicMouse_AddToCart_Btn =  WebDriver1.findElement(By.xpath(("//*[@id=\"default_products_page_container\"]//input[@type = \"submit\" and @value=\"Add To Cart\" and @name=\"Buy\" and @class=\"wpsc_buy_button\"]")));
        MagicMouse_AddToCart_Btn.click();

        //wait until item is added into the cart.
        WebDriverWait wait=new WebDriverWait(WebDriver1, 5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"default_products_page_container\"]/div[3]/div[2]/form/div[2]/div[1]/div[2]/p[text()]")));

        WebElement Checkout = WebDriver1.findElement(By.xpath(("//*[@id=\"header_cart\"]/a")));
        Checkout.click();
    }

    @Test(dependsOnMethods = "AccessoriesPageTC1",testName ="E2E")
    @Parameters("pExpectedQuantity")
    void checkoutPageTC1(String pExpectedQuantity){
        //   confirming Checkout quantity =1
        WebElement InputQuantity = WebDriver1.findElement(By.xpath(("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]")));
        Assert.assertEquals(InputQuantity.getAttribute("value"), pExpectedQuantity);

        //Continue Button
        WebElement Continue_Btn = WebDriver1.findElement(By.xpath(("//*[@id=\"checkout_page_container\"]/div[1]/a/span")));
        Continue_Btn.click();
    }

    @Test(dependsOnMethods = "checkoutPageTC1",testName ="E2E")
    @Parameters({"pInputEmail","pInputFirstName","pInputLastName",  "pInputAddress" , "pInputCity" ,"pInputUndefined","pInputCountry", "pInputPostalCode","pInputPhone"  })
    //Billing details form
    void checkoutPageTC2(String pInputEmail, String pInputFirstName,String pInputLastName,  String pInputAddress , String pInputCity ,String pInputUndefined,String pInputCountry, String pInputPostalCode,String pInputPhone ){
        //waiting for the first element to be avaialble
        WebDriverWait wait = new WebDriverWait(WebDriver1, 7000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"wpsc_checkout_form_9\"]")));

        WebElement InputEmail = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_9\"]")));
        InputEmail.sendKeys(pInputEmail);

        WebElement InputFirstName = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_2\"]")));
        InputFirstName.sendKeys(pInputFirstName);

        WebElement InputLastName = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_3\"]")));
        InputLastName.sendKeys(pInputLastName);

        WebElement InputAddress = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_4\"]")));
        InputAddress.sendKeys(pInputAddress);

        WebElement InputCity = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_5\"]")));
        InputCity.sendKeys(pInputCity);

        WebElement InputUndefined = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_6\"]")));
        InputUndefined.sendKeys(pInputUndefined);

         //Country Drop down Menu
        WebElement InputCountryDropDown = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_7\"]")));
        Select Country = new Select(InputCountryDropDown);
        Country.selectByVisibleText(pInputCountry);

        WebElement InputPostalCode = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_8\"]")));
        InputPostalCode.sendKeys(pInputPostalCode);
        WebElement InputPhone = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_checkout_form_18\"]")));
        InputPhone.sendKeys(pInputPhone);

        // Perimeters not needed
        WebElement SameAsBillingAddressCheckBox = WebDriver1.findElement(By.xpath(("//*[@id=\"shippingSameBilling\"]")));
        SameAsBillingAddressCheckBox.click();
        WebElement PurchaseBtn = WebDriver1.findElement(By.xpath(("//*[@id=\"wpsc_shopping_cart_container\"]/form/div[4]/div/div/span/input")));
        PurchaseBtn.click();
    }

    @Test(dependsOnMethods = "checkoutPageTC2",testName ="E2E")
    @Parameters("pThankYouText")
    void TransactionResultsPageTC1(String pThankYouText){
        WebElement ThankYouText = WebDriver1.findElement(By.xpath(("//*[@id=\"post-30\"]/div/div[2]/p[1]")));
        Assert.assertEquals(pThankYouText ,ThankYouText.getText());

        WebElement PurchaseSummary = WebDriver1.findElement(By.xpath(("//*[@id=\"post-30\"]/div/div[2]/table/tbody/tr")));
        String sPurchaseSummary = PurchaseSummary.getText();
        System.out.println(sPurchaseSummary);
    }
}
