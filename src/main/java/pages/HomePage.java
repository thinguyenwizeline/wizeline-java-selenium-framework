package pages;
import objects.HomeObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import libs.Common;
import libs.Config;

public class HomePage {

    private Common _common = new Common();
    private HomeObjects _homeObjects = new HomeObjects();
    private Logger log = Logger.getLogger(this.getClass());

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, _homeObjects);
    }

    /**
     * Logout from Home page
     * @param driver
     * @return
     */
    public boolean logout(WebDriver driver) {
        try {
            _common.clickObject(driver, _homeObjects.btnLogout);
            return true;
        } catch (Exception e) {
            log.error("Failed to logout with error: " + e.getMessage());
            return false;
        }

    }


}
