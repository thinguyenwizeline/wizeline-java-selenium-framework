package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import libs.Config;

public class TestBase {

    protected static WebDriver driver;
    ExtentHtmlReporter htmlReporter;
    ExtentReports report;
    ExtentTest test;
    protected Logger log = Logger.getLogger(this.getClass());

    /**
     * Constructor of TestBase to: Set Driver + Render all elements on All pages
     */
    public TestBase() {

        TestBase.driver = setDriver();
        log = Logger.getLogger(TestBase.class.getName());
    }

    /**
     * Set Driver for automation project and read it from config file
     */
    public WebDriver setDriver() {

        String browser = Config.getConfig("browser");

        if (browser.equalsIgnoreCase("CHROME")) {
            System.setProperty(Config.getConfig("chrome.key"), Config.getConfig("chrome.path"));
            TestBase.driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            System.setProperty(Config.getConfig("firefox.key"), Config.getConfig("firefox.path"));
            TestBase.driver = new FirefoxDriver();
        } else {

        }
        return driver;
    }

    @BeforeClass
    public void beforeClass(){
        htmlReporter = new ExtentHtmlReporter("./test-output/report.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);

        test = report.createTest("Login","Verify login function");
        log.info("Test base - before class");
        test.log();
        TestBase.driver.manage().window().maximize();
        TestBase.driver.navigate().to(Config.getConfig("baseUrl"));
    }


    @AfterClass
    public void afterClass(){
        log.info("Test base - after class");
        TestBase.driver.quit();
    }


}
