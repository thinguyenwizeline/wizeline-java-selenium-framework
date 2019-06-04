package pages;

import libs.Common;
import objects.HomeObjects;
import objects.LoginObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected Common _common;
    protected LoginObjects _loginObjects;
    protected HomeObjects _homeObjects;

    public BasePage(WebDriver driver){
        this.driver = driver;
        _common = new Common(driver);
        _loginObjects = new LoginObjects();
        _homeObjects = new HomeObjects();
        PageFactory.initElements(driver, this);
    }
}
