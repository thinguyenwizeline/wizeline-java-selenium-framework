package libs;

import base.LibBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyCommon extends LibBase {
    private WebDriver driver;

    public MyCommon(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds) {

        WebElement element;

        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS.SECONDS); //nullify implicitlyWait()

            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //reset implicitlyWait
            return element; //return the element

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Set text
     * @param by
     * @param sText
     */
    public boolean setText(By by, String sText) {
        WebElement e = waitForElementPresent(driver, by, 5000);
        if(e != null){
            e.sendKeys(sText);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Set text
     * @param by
     */
    public boolean clickObject(By by) {
        WebElement e = waitForElementPresent(driver, by, 5000);
        if(e != null){
            e.click();
            return true;
        }
        else {
            return false;
        }
    }


}
