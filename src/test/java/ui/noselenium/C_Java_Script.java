package test.java.ui.noselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C_Java_Script {
    WebDriver driver;
    WebDriverWait wait;
    By privateCabinet = By.cssSelector("[name='signin']");
    By registerBtn = By.cssSelector("[class='auth-modal__register-link']");
    By userNameBtn = By.cssSelector("[formcontrolname='username']");
    By registerActionBtn = By.cssSelector("[class='button button_size_large button_color_green auth-modal__submit']");
    String redBorder = "rgb(248, 65, 71)";
    By banner = By.cssSelector("#rz-banner");
    String jsScript = "const baner = document.getElementById(\"rz-banner\"); const style = baner && baner.style; style.width = 0; style.height = 0";

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void checkAllRed() throws InterruptedException {
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        wait.until(ExpectedConditions.elementToBeClickable(privateCabinet));
        wait.until(ExpectedConditions.visibilityOfElementLocated(banner));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsScript);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(banner)));
        //Thread.sleep(2000);
        String jsScrapScript = "const elArr = document.getElementsByClassName(\"f-menu-l-i-link f-menu-l-i-link-arrow sprite-side novisited\"); return Array.from(elArr).map(i => i.innerText).join(', ')";
        System.out.println(js.executeScript(jsScrapScript));
        js.executeScript("arguments[0].click();", driver.findElement(privateCabinet));
        Thread.sleep(10000);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
