package testNgListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test passed successfully "+iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Reporter.log("Capturing screenshot for the Failed test "+iTestResult.getName());
        System.out.println("Capturing screenshot for the Failed test "+iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log("<a href=\"E:\\v_app\\Observations\\account_creation.png\" target=\"_blank\">ScreenShotLink</a>");
        Reporter.log("<br>");
        Reporter.log("<a href=\"E:\\v_app\\Observations\\account_creation.png\" target=\"_blank\"><img height=200 width=200 src=\"E:\\v_app\\Observations\\account_creation.png\"></a>");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
