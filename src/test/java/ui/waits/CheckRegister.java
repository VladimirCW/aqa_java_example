package test.java.ui.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckRegister {
    WebDriver driver;
    WebDriverWait wait;
    By privateCabinet = By.cssSelector("[name='signin']");
    By registerBtn = By.cssSelector("[class='auth-modal__register-link']");
    By userNameBtn = By.cssSelector("[formcontrolname='username']");
    By registerActionBtn = By.cssSelector("[class='button button_size_large button_color_green auth-modal__submit']");
    String redBorder = "rgb(248, 65, 71)";

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void checkAllRed() {
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        wait.until(ExpectedConditions.elementToBeClickable(privateCabinet));
        driver.findElement(privateCabinet).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
        driver.findElement(registerBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(userNameBtn));
        driver.findElement(userNameBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(registerActionBtn));
        driver.findElement(registerActionBtn).click();
        wait.until(ExpectedConditions.and(
           ExpectedConditions.attributeToBe(userNameBtn, "border-color", redBorder)
        ));
        assertEquals(redBorder, driver.findElement(userNameBtn).getCssValue("border-color"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
