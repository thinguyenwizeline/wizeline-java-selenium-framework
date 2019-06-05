package libs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtils {
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentReports extentReports;
    protected ExtentTest test;
    public ExtentReportUtils (String path,String testName){
        extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+path);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        test = extentReports.createTest(testName);
    }
    public void setInfo (String infoMessage){
        test.info(infoMessage);
    }
    public void setPass (String passMessage){
        test.pass(passMessage);
    }
    public void setFail (String failMessage){
        test.fail(failMessage);
    }
    public void endWriteReport(){
        extentReports.flush();
    }

}
