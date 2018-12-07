package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



//Ideally every web page should have its own PageObject CLass.
public class PageObject {

   WebDriver webDriver;

        By ProductCategory =         By.xpath("//*[@id=\"menu-item-33\"]/a");
        By Accessories =             By.xpath("//*[@id=\"menu-item-34\"]/a");
        By magicMouseAddToCartBtn  = By.xpath("//*[@id=\"default_products_page_container\"]//input[@type = \"submit\" and @value=\"Add To Cart\" and @name=\"Buy\" and @class=\"wpsc_buy_button\"]");
        By addToCartMessage =        By.xpath("//*[@id=\"default_products_page_container\"]/div[3]/div[2]/form/div[2]/div[1]/div[2]/p[text()]");
        By checkOut =                By.xpath("//*[@id=\"header_cart\"]/a");
        By inputQuantity =           By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/table/tbody/tr[2]/td[3]/form/input[1]");
        By continueBtn =             By.xpath("//*[@id=\"checkout_page_container\"]/div[1]/a/span");
        By inputEmail=               By.xpath("//*[@id=\"wpsc_checkout_form_9\"]");
        By inputFirstName =          By.xpath("//*[@id=\"wpsc_checkout_form_2\"]");
        By inputLastName =           By.xpath("//*[@id=\"wpsc_checkout_form_3\"]");
        By inputAddress =            By.xpath("//*[@id=\"wpsc_checkout_form_4\"]");
        By inputCity =               By.xpath("//*[@id=\"wpsc_checkout_form_5\"]");
        By inputUndefined =          By.xpath("//*[@id=\"wpsc_checkout_form_6\"]");
        By inputCountryDropDown =    By.xpath("//*[@id=\"wpsc_checkout_form_7\"]");
        By inputPostalCode =         By.xpath("//*[@id=\"wpsc_checkout_form_8\"]");
        By inputPhone =              By.xpath("//*[@id=\"wpsc_checkout_form_18\"]");
        By sameAsBillingAddressCheckBox = By.xpath("//*[@id=\"shippingSameBilling\"]");
        By purchaseBtn =             By.xpath("//*[@id=\"wpsc_shopping_cart_container\"]/form/div[4]/div/div/span/input");
        By thankYouText =            By.xpath("//*[@id=\"post-30\"]/div/div[2]/p[1]");
        By purchaseSummary =         By.xpath("//*[@id=\"post-30\"]/div/div[2]/table/tbody/tr");

        //constructor
        public PageObject(WebDriver driver){
            this.webDriver=driver;
        }

        public WebElement getProductCategory(){
           return(webDriver.findElement(ProductCategory));
        }

        public WebElement getAccessories(){
            return(webDriver.findElement(Accessories));
        }

        public WebElement getMagicmouseAddToCartBtn(){
            return(webDriver.findElement(magicMouseAddToCartBtn));
        }

        public WebElement getAddToCartMessage(){
            return (webDriver.findElement(addToCartMessage));
        }

        public WebElement getCheckOut(){
            return (webDriver.findElement(checkOut));
        }

        public WebElement getInputQuantity(){
            return (webDriver.findElement(inputQuantity));
        }

        public WebElement getContinueBtn(){
            return (webDriver.findElement(continueBtn));
        }

        public WebElement getInputEmail(){
            return (webDriver.findElement(inputEmail));
        }

        public WebElement getInputFirstName(){
            return (webDriver.findElement(inputFirstName ));
        }

        public WebElement getInputLastName(){
            return (webDriver.findElement(inputLastName));
        }

        public WebElement getInputAddress (){
            return (webDriver.findElement(inputAddress));
        }

        public WebElement getInputCity (){
             return (webDriver.findElement(inputCity));
        }

        public WebElement getInputUndefined (){
            return (webDriver.findElement(inputUndefined));
        }

        public WebElement getInputCountryDropDown(){

            return (webDriver.findElement(inputCountryDropDown));
        }

        public WebElement getInputPostalCode(){
            return (webDriver.findElement(inputPostalCode));
        }

        public WebElement getInputPhone(){
            return (webDriver.findElement(inputPhone));
        }

        public WebElement getSameAsBillingAddressCheckBox() {
            return (webDriver.findElement(sameAsBillingAddressCheckBox));
        }

        public WebElement getPurchaseBtn(){
            return (webDriver.findElement(purchaseBtn));
        }

        public WebElement getThankYouText(){
            return (webDriver.findElement(thankYouText));
        }

        public WebElement getPurchaseSummary(){
            return (webDriver.findElement(purchaseSummary));
        }

}
