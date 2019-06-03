package test;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import base.TestBase;
import libs.Config;
import libs.ExcelUtils;

public class TC01_Login extends TestBase{

    LoginPage _login = new LoginPage(driver);
    HomePage _home = new HomePage(driver);


    @DataProvider(name="login_data")
    public Object [][] credentials() throws Exception {
        System.out.println("data provider function...........");
        int rows = -1;

        ExcelUtils.setExcelFile(Config.getConfig("test.input.logindata"), Config.getConfig("test.input.logindata.sheetname"));
        rows = ExcelUtils.getRowCount();
        Object [][] data = new Object [rows+1][2];
        for (int i = 0; i <= rows; i++) {
            data[i][0] = ExcelUtils.getCellData(i, 0); // username
            data[i][1] = ExcelUtils.getCellData(i, 1); // password
        }

        return data;
    }

    /**
     * Login with user/password from Excel
     * @param username
     * @param password
     * @throws Exception
     */
    @Test(dataProvider="login_data")
    public void LoginAndLogout(String username, String password) throws Exception {
        _login.login(driver, username, password);
        _home.logout(driver);
    }
}
