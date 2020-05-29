package test.java.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements
        ISuiteListener, ITestListener, IInvokedMethodListener{
    Screenshot screenshot;
    Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        logger.trace("BEFORE INVOCATION");
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
       // System.out.println("AFTER INVOKATION");
    }

    @Override
    public void onStart(ISuite iSuite) {
        //System.out.println("ON SUITE START");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        //System.out.println("ON SUITE FINISH");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("ON TEST START");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
       // System.out.println("ON TEST SUCCESS");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        new Screenshot((WebDriver) iTestResult.getTestContext().getAttribute("driver")).makeScreenshot(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
       // System.out.println("ON TEST SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //System.out.println("ON START");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //System.out.println("ON FINISH");
    }
}
