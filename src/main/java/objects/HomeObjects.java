package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeObjects {

    // Logout button
    @FindBy (linkText = "Log out")
    public WebElement btnLogout;
}
