package pages;

import org.openqa.selenium.WebDriver;

public class MyHomePage extends MyBasePage{

    public MyHomePage(WebDriver driver) {

        super(driver);
    }

    public MyLoginPage logout() {
        _common.clickObject(_myHomePageLocators.by_btnLogout);
        return new MyLoginPage(driver);
    }


}
