package test.java.ui.po;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTestSetup {
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser, ITestContext testContext) {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        //options.addArguments("--incognito");
        //driver = new ChromeDriver(options);
        try {
            switch (browser) {
                case "chrome":
                    ChromeOptions optionsch = new ChromeOptions();
                    optionsch.addArguments("--disable-notifications"); //usefull
                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), optionsch);
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    FirefoxOptions optionsff = new FirefoxOptions();
                    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), optionsff);
                    break;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        testContext.setAttribute("driver", driver);

        /*Cookie ckUa = new Cookie("slang", "ua", "/");
        driver.get("https://rozetka.com.ua/ua/404.html");
        driver.manage().addCookie(ckUa);*/
        //driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        attachString();
        attachScreenshot(testResult);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    @Attachment
    private String attachString() {
        return "Helo, I am a string attachment";
    }

    @Attachment(value = "screenshot", type = "image/png")
    private byte[] attachScreenshot(ITestResult iTestResult) {
        WebDriver driver = (WebDriver) iTestResult.getTestContext().getAttribute("driver");
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
