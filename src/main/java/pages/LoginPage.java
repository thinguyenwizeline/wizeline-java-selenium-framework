package pages;
import com.aventstack.extentreports.ExtentTest;
import objects.LoginObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import libs.Common;
import libs.Config;

public class LoginPage extends BasePage{

    public LoginPage (WebDriver driver) {

        super(driver);
    }

    public HomePage login(String username, String password) {
        try {
            _common.setText(driver, _loginObjects.txtUserId, username);
            _common.setText(driver, _loginObjects.txtPassword, password);
            _common.clickObject(driver, _loginObjects.btnLogin);
            return new HomePage(driver);
        } catch (Exception e) {
            System.out.println("Failed to login with error: " + e.getMessage());
            return null;
        }

    }
}
