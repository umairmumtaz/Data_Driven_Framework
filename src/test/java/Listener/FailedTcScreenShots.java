package Listener;
import java.io.*;

import DriverManager.BrowserDriverManager;
//import org.apache.commons.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class FailedTcScreenShots{


    public void takeScreenShot() throws Exception{
       WebDriver driver = BrowserDriverManager.getInstance().getWebDriver();

    //Call take screenshot function
     this.takeSnapShot(driver, "c://test.png") ;
    }


    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

       //Copy file at destination
        //fileUtils.copyFile(SrcFile, new File(fileWithPath));

    }

}