package pages;

import libs.MyCommon;
import objects.MyHomeObjects;
import objects.MyLoginObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MyBasePage {
    protected WebDriver driver;

    protected MyCommon _common;
    protected MyLoginObjects _myLoginLocators;
    protected MyHomeObjects _myHomePageLocators;

    public MyBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        _common = new MyCommon(driver);
        _myLoginLocators = new MyLoginObjects();
        _myHomePageLocators = new MyHomeObjects();
    }
}
