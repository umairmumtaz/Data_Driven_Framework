package TestCases;
import Configuration.ConfigFileReader;
import PageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import DriverManager.BrowserDriverManager;
import org.testng.annotations.BeforeSuite;

//Ideally every Web Page should have its own TC Class
public class DemoQa {

    WebDriver webDriver1;
    PageObject pageObject;
    String url = ConfigFileReader.getPropertyValue("website.Url"); //getting url from configuration file through ConfigFileReader Class.

    @BeforeSuite
    void browserSetup() {
        webDriver1 = BrowserDriverManager.getInstance().getWebDriver(); //need to have same driver same instance
        pageObject = new PageObject(webDriver1);// I
        webDriver1.manage().deleteAllCookies(); //delete all cookies
     }

    @Test(testName ="E2E")
    void loadPageTC1(){
        webDriver1.get(url); //getting url from above string variable
    }

    @Test(dependsOnMethods = "loadPageTC1",testName ="E2E")
    void homePageTC1(){
        Actions hoverClick = new Actions(webDriver1);
        hoverClick.moveToElement(pageObject.getProductCategory()).click(pageObject.getAccessories()).build().perform();
    }

    @Test(dependsOnMethods = "homePageTC1",testName ="E2E")
    @Parameters("pExpectedMessage")
    void AccessoriesPageTC1(String pExpectedMessage){
        //Magic Mouse Add to Cart Button
        pageObject.getMagicmouseAddToCartBtn().click();
        //wait until item is added into the cart.
        WebDriverWait wait=new WebDriverWait(webDriver1, 5000);
        wait.until(ExpectedConditions.visibilityOf(pageObject.getAddToCartMessage()));
       //check out Button
        pageObject.getCheckOut().click();
    }

    @Test(dependsOnMethods = "AccessoriesPageTC1",testName ="E2E")
    @Parameters("pExpectedQuantity")
    void checkoutPageTC1(String pExpectedQuantity){
        //  confirming Checkout quantity =1
        Assert.assertEquals(pageObject.getInputQuantity().getAttribute("value"), pExpectedQuantity);
        //Continue Button
        pageObject.getContinueBtn().click();
    }

    @Test(dependsOnMethods = "checkoutPageTC1",testName ="E2E")
    @Parameters({"pInputEmail","pInputFirstName","pInputLastName",  "pInputAddress" , "pInputCity" ,"pInputUndefined","pInputCountry", "pInputPostalCode","pInputPhone"  })
    //Billing details form
    void checkoutPageTC2(String pInputEmail, String pInputFirstName,String pInputLastName,  String pInputAddress , String pInputCity ,String pInputUndefined,String pInputCountry, String pInputPostalCode,String pInputPhone ){
        //waiting for the first element(email texbox) to be available
        WebDriverWait wait = new WebDriverWait(webDriver1, 7000);
        wait.until(ExpectedConditions.visibilityOf(pageObject.getInputEmail()));
        //type Email address
        pageObject.getInputEmail().sendKeys(pInputEmail);
        //type First Name
        pageObject.getInputFirstName().sendKeys(pInputFirstName);
        //type Last Name
        pageObject.getInputLastName().sendKeys(pInputLastName);
        //type Address
        pageObject.getInputAddress().sendKeys(pInputAddress);
        //type City
        pageObject.getInputCity().sendKeys(pInputCity);
        //input Undefined (State)
        pageObject.getInputUndefined().sendKeys(pInputUndefined);
        // Country Drop Down, using Select class
        Select Country = new Select(pageObject.getInputCountryDropDown());
        Country.selectByVisibleText(pInputCountry);
        //type Postal Code.
        pageObject.getInputPostalCode().sendKeys(pInputPostalCode);
        // type Phone Number
        pageObject.getInputPhone().sendKeys(pInputPhone);
        // Checkbox: Same as billing Address
        pageObject.getSameAsBillingAddressCheckBox().click();
        //Click Purchase Button
        pageObject.getPurchaseBtn().click();
    }

    @Test(dependsOnMethods = "checkoutPageTC2",testName ="E2E")
    @Parameters("pThankYouText")
    void transactionResultsPageTC1(String pThankYouText){
        //Verify "Thank you........" Message
        Assert.assertEquals(pThankYouText ,pageObject.getThankYouText().getText());
        //Purchase Summary Details
        String sPurchaseSummary = pageObject.getPurchaseSummary().getText();
        System.out.println(sPurchaseSummary);
        //Close current window
        webDriver1.close();
        //Close all instances
        webDriver1.quit();
    }
}
