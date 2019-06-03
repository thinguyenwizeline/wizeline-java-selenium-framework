package pages;

import org.openqa.selenium.WebDriver;

public class MyLoginPage extends MyBasePage{

    public MyLoginPage(WebDriver driver) {
        super(driver);
    }

    public MyHomePage login( String username, String password) {

        _common.setText(_myLoginLocators.by_uid,username);
        _common.setText(_myLoginLocators.by_pass,username);
        _common.clickObject(_myLoginLocators.by_btnLogin);

        return new MyHomePage(driver);
    }
}
