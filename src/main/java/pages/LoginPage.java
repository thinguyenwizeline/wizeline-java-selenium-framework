package pages;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        _common.setText(_loginObjects.by_uid,username);
        _common.setText(_loginObjects.by_pass, password);
        _common.clickObject(_loginObjects.by_btnLogin);
        return new HomePage(driver);
    }
}
