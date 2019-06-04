package pages;
import com.sun.xml.internal.rngom.parse.host.Base;
import objects.HomeObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import libs.Common;
import libs.Config;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Logout from Home page
     * @return
     */
    public LoginPage logout() {
        try {
            _common.clickObject(driver, _homeObjects.btnLogout);
            return new LoginPage(driver);
        } catch (Exception e) {
            System.out.println("Failed to logout with error: " + e.getMessage());
            return null;
        }

    }


}
