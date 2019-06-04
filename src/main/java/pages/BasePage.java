package pages;

import libs.Common;
import libs.MyCommon;
import objects.HomeObjects;
import objects.LoginObjects;
import objects.MyHomeObjects;
import objects.MyLoginObjects;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;
    protected Common _common;
    protected HomeObjects _homeObjects;
    protected LoginObjects _loginObjects;
    protected Logger _log = Logger.getLogger(this.getClass());

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        _common = new Common(driver);
        _loginObjects = new LoginObjects();
        _homeObjects = new HomeObjects();
    }
}
