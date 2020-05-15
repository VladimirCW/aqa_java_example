package test.java.ui.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class B_Spinner {

    public static void main(String[] args) {
        By spinner = By.id("preload-it");
        By javaProg = By.cssSelector("a[href='https://itea.ua/courses-itea/java-programming/'] img");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://itea.ua/");

        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(spinner)));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(spinner)));
        wait.until(ExpectedConditions.elementToBeClickable(javaProg));

        driver.findElement(javaProg).click();

        driver.quit();
    }

}
