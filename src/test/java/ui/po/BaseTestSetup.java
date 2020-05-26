package test.java.ui.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.ui.po.utils.Screenshot;

public class BaseTestSetup {
    WebDriver driver;
    Screenshot screenshot;

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //usefull
        //options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        screenshot = new Screenshot(driver);
        /*Cookie ckUa = new Cookie("slang", "ua", "/");
        driver.get("https://rozetka.com.ua/ua/404.html");
        driver.manage().addCookie(ckUa);*/
        //driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        screenshot.makeScreenshot(testResult);
        driver.quit();
    }
}
