package pages;
import objects.LoginObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import libs.Common;
import libs.Config;

public class LoginPage {

    private Common _common = new Common();
    private LoginObjects _loginObjects = new LoginObjects();
    private Logger log = Logger.getLogger(this.getClass());


    public LoginPage (WebDriver driver) {
        PageFactory.initElements(driver, _loginObjects);
    }

    public void login(WebDriver driver) {
        _common.setText(driver, _loginObjects.txtUserId, Config.getConfig("username"));
        _common.setText(driver, _loginObjects.txtPassword, Config.getConfig("password"));
        _common.clickObject(driver, _loginObjects.btnLogin);
    }

    public boolean login(WebDriver driver, String username, String password) {
        try {
            _common.setText(driver, _loginObjects.txtUserId, username);
            _common.setText(driver, _loginObjects.txtPassword, password);
            _common.clickObject(driver, _loginObjects.btnLogin);
            return true;
        } catch (Exception e) {
            log.error("Failed to login with error: " + e.getMessage());
            return false;
        }

    }
}
