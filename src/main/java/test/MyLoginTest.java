package test;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyHomePage;
import pages.MyLoginPage;

public class MyLoginTest extends TestBase{

    MyLoginPage login = new MyLoginPage(driver);
    MyHomePage home = new MyHomePage(driver);


    @Test
    public void Login() throws Exception {
        MyHomePage homePage = login.login("mngr199123", "Nhuhuyen1502!");
        Assert.assertTrue(homePage!=null);
    }

    @Test
    public void Logout() throws Exception {
        MyHomePage homePage = login.login("mngr199123", "Nhuhuyen1502!");
        if(homePage != null) {
            home.logout();
        }
        else {
            Assert.fail();
        }
    }
}
