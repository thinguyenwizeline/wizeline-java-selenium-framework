package pages;

import objects.HomeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import libs.Common;


public class HomePage {

    WebDriver driver;
    private Common _common = new Common(driver);

    private HomeObjects _homeObjects = new HomeObjects();

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, _homeObjects);
    }

    /**
     * Logout from Home page
     *
     * @return
     */
    public LoginPage logout() {
        _common.clickObject(_homeObjects.by_btnLogout);
        return new LoginPage(driver);
    }


}
